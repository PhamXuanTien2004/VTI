package com.example.vtibedtn2506_usermanagement.service.impl;

import com.example.vtibedtn2506_usermanagement.dto.request.CreateUserDTO;
import com.example.vtibedtn2506_usermanagement.dto.request.UpdateUserDTO;
import com.example.vtibedtn2506_usermanagement.entity.User;
import com.example.vtibedtn2506_usermanagement.exception.BusinessException;
import com.example.vtibedtn2506_usermanagement.repository.UserRepository;
import com.example.vtibedtn2506_usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(CreateUserDTO createUserDTO) {
        if (createUserDTO.getFirstName() == null || createUserDTO.getFirstName().isBlank() ) {
            throw new BusinessException("First name is must not be null");
        }
        if (createUserDTO.getLastName() == null || createUserDTO.getLastName().isBlank() ) {
            throw new BusinessException("Last name is must not be null");
        }
        if (createUserDTO.getAddress() == null || createUserDTO.getAddress().isBlank() ) {
            throw new BusinessException("Adress is must not be null");
        }

        User user = new User();

        user.setFirstName(createUserDTO.getFirstName());
        user.setLastName(createUserDTO.getLastName());
        user.setAddress(createUserDTO.getAddress());
        user.setBirthday(createUserDTO.getBirthday());

        return userRepository.save(user);
    }

    @Override
    public User updateInfoUser(UpdateUserDTO updateUserDTO, Integer id) {

        if(id == null){
            throw new BusinessException("id is null");
        }
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new BusinessException("user not found");
        }

        if (updateUserDTO.getFirstName() == null || updateUserDTO.getFirstName().isBlank()) {
            throw new BusinessException("First name is must not be null");
        }
        if (updateUserDTO.getLastName() == null || updateUserDTO.getLastName().isBlank()) {
            throw new BusinessException("Last name is must not be null");
        }
        if (updateUserDTO.getAddress() == null || updateUserDTO.getAddress().isBlank()) {
            throw new BusinessException("Address is must not be null");
        }

        User userToUpdate = user.get();

        userToUpdate.setFirstName(updateUserDTO.getFirstName());
        userToUpdate.setLastName(updateUserDTO.getLastName());
        userToUpdate.setAddress(updateUserDTO.getAddress());

        return userRepository.save(userToUpdate);
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        if(firstName == null || firstName.isBlank()){
            throw new BusinessException("First name is must not be null");
        }

        return userRepository.findByFirstName(firstName);

    }

    @Override
    public boolean deleteUser(Integer id) {
        if(id == null){
            throw new BusinessException("id is null");
        }
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
        return true;
    }

}

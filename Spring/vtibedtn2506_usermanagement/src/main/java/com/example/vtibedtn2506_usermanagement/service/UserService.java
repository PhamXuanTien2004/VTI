package com.example.vtibedtn2506_usermanagement.service;

import com.example.vtibedtn2506_usermanagement.dto.request.CreateUserDTO;
import com.example.vtibedtn2506_usermanagement.dto.request.UpdateUserDTO;
import com.example.vtibedtn2506_usermanagement.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll ();
    User createUser(CreateUserDTO request);
    User updateInfoUser(UpdateUserDTO request, Integer id);
    List<User> findByFirstName(String firstName);
    boolean deleteUser(Integer id);
}

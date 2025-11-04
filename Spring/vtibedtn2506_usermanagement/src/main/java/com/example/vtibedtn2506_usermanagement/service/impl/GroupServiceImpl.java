package com.example.vtibedtn2506_usermanagement.service.impl;

import com.example.vtibedtn2506_usermanagement.dto.request.CreateGroupDTO;
import com.example.vtibedtn2506_usermanagement.entity.Group;
import com.example.vtibedtn2506_usermanagement.exception.BusinessException;
import com.example.vtibedtn2506_usermanagement.repository.GroupRepository;
import com.example.vtibedtn2506_usermanagement.repository.UserRepository;
import com.example.vtibedtn2506_usermanagement.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group createGroup(CreateGroupDTO request) {
        if(request.getNameGroup()==null || request.getNameGroup().isBlank()){
            throw new IllegalArgumentException("Group name cannot be blank");
        }
        if(request.getDescription()==null || request.getDescription().isBlank()){
            throw new IllegalArgumentException("Group description cannot be blank");
        }

        Group newGroup = new Group();
        newGroup.setNameGroup(request.getNameGroup());
        newGroup.setDescription(request.getDescription());

        return groupRepository.save(newGroup);
    }

    @Override
    public Group updateGroup(Integer id, CreateGroupDTO request) {
        if(id == null){
            throw new BusinessException("Id is null");
        }
        Group newGroup = groupRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Group id =" + id + " not exist"));

        if(request.getNameGroup()==null || request.getNameGroup().isBlank()){
            throw new BusinessException("Group name cannot be blank");
        }
        if(request.getDescription()==null || request.getDescription().isBlank()){
            throw new BusinessException("Group description cannot be blank");
        }

        newGroup.setNameGroup(request.getNameGroup());
        newGroup.setDescription(request.getDescription());

        return groupRepository.save(newGroup);
    }

    @Override
    public List<Group> searchByName(String name) {
        if(name==null || name.isBlank()){
            throw new BusinessException("Name cannot be blank");
        }

        return groupRepository.searchByNameGroup(name);
    }

    @Override
    public boolean deleteById(Integer id) {
        if(id==null){
            throw new IllegalArgumentException("Id is null");
        }
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
        return true;
    }


}

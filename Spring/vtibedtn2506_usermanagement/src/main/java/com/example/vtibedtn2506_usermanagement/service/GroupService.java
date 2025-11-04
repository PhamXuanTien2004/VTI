package com.example.vtibedtn2506_usermanagement.service;

import com.example.vtibedtn2506_usermanagement.dto.request.CreateGroupDTO;
import com.example.vtibedtn2506_usermanagement.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAll ();
    Group createGroup(CreateGroupDTO request);
    Group updateGroup(Integer id, CreateGroupDTO request);
    List<Group> searchByName(String name);
    boolean deleteById(Integer id);
}

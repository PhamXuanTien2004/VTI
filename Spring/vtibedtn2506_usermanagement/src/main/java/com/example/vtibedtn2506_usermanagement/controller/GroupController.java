package com.example.vtibedtn2506_usermanagement.controller;

import com.example.vtibedtn2506_usermanagement.dto.request.CreateGroupDTO;
import com.example.vtibedtn2506_usermanagement.entity.Group;
import com.example.vtibedtn2506_usermanagement.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    @GetMapping()
    public List<Group> getAll() {
        return groupService.getAll();
    }

    @PostMapping()
    public Group createGroup(@RequestBody CreateGroupDTO request) {
        return groupService.createGroup(request);
    }

    @PutMapping("/{id}")
    public Group updateGroup(@PathVariable Integer id, @RequestBody CreateGroupDTO request) {
        return groupService.updateGroup(id, request);
    }

    @GetMapping("/search")
    public List<Group> searchByName(@RequestParam String name) {
        return groupService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        return groupService.deleteById(id);
    }
}

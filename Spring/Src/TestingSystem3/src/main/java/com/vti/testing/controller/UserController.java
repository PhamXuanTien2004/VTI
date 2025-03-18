package com.vti.testing.controller;

import com.vti.testing.dto.UserDTO;
import com.vti.testing.entity.User;
import com.vti.testing.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    public IUserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<User> getAllUsers(){
        List<User> getAllUsers = userService.getAllUsers();
        return modelMapper.map(users, new TypeToken<List<UserDTO>>(){}.getType());
    }
}

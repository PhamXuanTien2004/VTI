package com.vti.testing.controller;

import com.vti.testing.dto.UserDTO;
import com.vti.testing.entity.User;
import com.vti.testing.service.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<UserDTO> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return modelMapper.map(users, new TypeToken<List<UserDTO>>(){}.getType());
    }

    @GetMapping("{id}")
    public UserDTO getUserById (@PathVariable int id){
        User user = userService.getUserById(id);
        return modelMapper.map(user, UserDTO.class);
    }
}

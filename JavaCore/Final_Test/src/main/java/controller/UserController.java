package controller;

import entity.User;
import service.IUserService;
import service.UserService;

import java.util.List;

public class UserController {
    private IUserService userService = new UserService();

    public List <User> getAllUser (){
        return userService.getAllUsers();
    }

    public User getUserById (int id){
        return userService.getUserById(id);
    }

    public boolean deleteUserById (int id){
        return userService.deleteUserById(id);
    }
}

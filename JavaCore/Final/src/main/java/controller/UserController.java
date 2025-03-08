package controller;

import entity.User;
import service.IUserService;
import service.UserService;

import java.util.List;


public class UserController {
    private IUserService userService = new UserService();

    public User getEmployeeByProjectId(int ProjectId){
        return userService.getEmployeeByProjectId(ProjectId);
    }

    public List<User> getManager() {
        return userService.getManager();
    }

    public User loginManager(String email, String password){
        return userService.loginManager(email,password);
    }
}
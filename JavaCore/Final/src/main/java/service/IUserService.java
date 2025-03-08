package service;

import entity.User;

import java.util.List;

public interface IUserService {
    User getEmployeeByProjectId(int ProjectId);

    List <User> getManager();

    User loginManager(String email, String password);
}
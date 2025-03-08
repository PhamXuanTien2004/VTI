package service;

import entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    User getUserById(int id);

    boolean deleteUserById (int id);
}

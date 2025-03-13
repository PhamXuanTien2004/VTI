package service;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    User getUserById(int id);

    boolean deleteUserById (int id);

    User loginAdmin (String email, String password) ;

    User login (String email, String password);
}

package repository;

import entity.User;

import java.util.List;

public interface IUserRepository {
    List<User> getAllUsers();

    User getUserById(int id);

    boolean deleteUserById (int id);

    User login (String email, String password);

    User loginAdmin (String a, String b) ;
}

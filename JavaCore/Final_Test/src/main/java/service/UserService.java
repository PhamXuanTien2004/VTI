package service;

import entity.User;
import repository.IUserRepository;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService{
    private IUserRepository userRepository = new UserRepository();
    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public boolean deleteUserById(int id) {
        return userRepository.deleteUserById(id);
    }

    @Override
    public User loginAdmin(String a, String b) {
        return userRepository.loginAdmin(a,b);
    }

    @Override
    public User login(String email, String password) {
        return userRepository.login(email, password);
    }
}

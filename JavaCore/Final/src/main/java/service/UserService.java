package service;

import repository.IUserRepository;
import repository.UserRepository;
import entity.User;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();
    @Override
    public User getEmployeeByProjectId(int ProjectId) {
        return userRepository.getEmployeeByProjectId(ProjectId);
    }

    @Override
    public List<User> getManager() {
        return userRepository.getManager();
    }

    @Override
    public User loginManager(String email, String password) {
        return userRepository.loginManager(email, password);
    }
}

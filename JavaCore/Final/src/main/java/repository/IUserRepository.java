package repository;

import entity.User;

import java.util.List;

public interface IUserRepository {

    User getEmployeeByProjectId(int ProjectId);

    List <User> getManager();

    User loginManager(String email, String password);
}

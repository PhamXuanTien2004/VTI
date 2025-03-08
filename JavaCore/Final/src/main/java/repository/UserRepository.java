package repository;

import entity.User;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepository implements IUserRepository{

    @Override
    public User getEmployeeByProjectId(int ProjectId) {
        String sql = "SELECT * FROM user Right JOIN employee USING(id) WHERE ProjectId = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,ProjectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("FullName");
                String email = resultSet.getString("Email");
                return new User(id, fullName, email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getManager() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM User Right JOIN Manager USING(id)";
        try (Connection connection = JDBCUtils.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("FullName");
                String email = resultSet.getString("Email");
                users.add(new User(id, fullName, email));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return users;
    }

    @Override
    public User loginManager(String email, String password) {
        String sql = "SELECT * FROM User Right JOIN Manager USING(id) WHERE Email =  ? and `PassWord` = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String fullName = resultSet.getString("FullName");
                return new User( fullName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}

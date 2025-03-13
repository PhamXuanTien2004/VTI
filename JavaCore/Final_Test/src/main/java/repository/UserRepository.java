package repository;

import entity.User;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection connection = JDBCUtils.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
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
    public User getUserById(int a) {
        String sql = "SELECT * FROM final_demo.user where id = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,a);
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
    public boolean deleteUserById(int id) {
        String sql = "DELETE FROM user WHERE id = ?";

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            int row = preparedStatement.executeUpdate(); // Thực hiện DELETE

            return row > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User login(String a, String b) {
        String sql = "SELECT * FROM `User` WHERE Email =  ? and `PassWord` = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,a);
            preparedStatement.setString(2,b);
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

    @Override
    public User loginAdmin(String a, String b) {
        String sql = "SELECT * FROM `User` RIGHT JOIN `Admin`USING (id) WHERE Email =  ? and `PassWord` = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,a);
            preparedStatement.setString(2,b);
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
}

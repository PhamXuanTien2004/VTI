package repository;

import entity.Department;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository implements IDepartmentRepository {
    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();

        try (Connection connection = JDBCUtils.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Department");
            while (resultSet.next()) {
                int id = resultSet.getInt("department_id");
                String name = resultSet.getString("department_name");
                departments.add(new Department(id, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return departments;
    }

    @Override
    public Department getDepartmentById(int id) {
        String sql = "SELECT * FROM Department WHERE department_id = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("department_name");
                return new Department(id, name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean createDepartment(Department department) {
        String sql = "INSERT INTO Department(department_name) VALUES (?)";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, department.getName());
            int row = preparedStatement.executeUpdate();
            return row > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDepaertment(Department department) {
        String sql = "UPDATE Department SET department_name = ? WHERE department_id = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, department.getName());
            int row = preparedStatement.executeUpdate();
            return row > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteDepartment(int id) {
        String sql = "DELETE FROM Department WHERE department_id = ?";

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id); // Đúng tham số truyền vào

            int row = preparedStatement.executeUpdate(); // Thực hiện DELETE
            return row > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



}
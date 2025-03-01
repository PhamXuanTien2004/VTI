import entity.Department;
import utils.JDBCUtils;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Program {
    public static void main(String[] args) throws Exception {
//        List<Department> departments = getAllDepartments();
//        departments.forEach(department -> System.out.println(department));
        Department department = getDepartmentById(5);
        System.out.println(department);
    }

public static Department getDepartmentById (int id) throws Exception {
        String sql = "SELECT * FROM department WHERE department_id = ?";
        try (Connection connection = (Connection) JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                String name = resultSet.getString("department_id");
                return new Department(id,name);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    return null;
}

    public static List<Department> getAllDepartments()throws Exception{
        List<Department> departments = new ArrayList<>();
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/database.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(url,user,password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM department");
            while (resultSet.next()) {
                int id = resultSet.getInt("department_id");
                String name = resultSet.getString("department_name");
                departments.add(new Department(id, name));
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return departments;
    }
}

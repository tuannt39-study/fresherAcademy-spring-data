package vn.its.dao;

import org.springframework.stereotype.Component;
import vn.its.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component("StudentJdbcDao")
public class StudentJdbcDao {
    private static String jdbcUrl = "jdbc:mysql://localhost:3306/education?useUnicode=true&characterEncoding=utf8&useSSL=false";
    private Connection connection = null;
    private Statement statement = null;

    private void createConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //Get a connection
                connection = DriverManager.getConnection(jdbcUrl, "root", "12345");
            } catch (Exception except) {
                System.out.println("Connection Failed! Check output console");
                except.printStackTrace();
            }
        }
    }

    private void shutdown() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                DriverManager.getConnection(jdbcUrl + ";shutdown=true");
                connection.close();
            }
        } catch (SQLException sqlExcept) {

        }

    }

    public void insertStudent(Student student) {
        createConnection();
        try {
            statement = connection.createStatement();
            statement.execute("insert into student values (" + student.getId() + ",'" + student.getName() + "','" + student.getLocation() + "')");
            statement.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }

    public List<Student> getAllStudent() {
        createConnection();
        List<Student> students = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from student");
            ResultSetMetaData rsmd = results.getMetaData();
            while (results.next()) {
                int id = results.getInt(1);
                String name = results.getString(2);
                String location = results.getString(3);
                students.add(new Student(id, name, location));
            }
            results.close();
            statement.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return students;
    }

}

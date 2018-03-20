package vn.its.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.its.model.Student;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component("studentJdbcTemplateDao")
public class StudentJdbcTemplateDao {
    private Connection connection = null;
    private Statement statement = null;

    @Autowired
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private void createConnection() {
        if (connection == null) {
            try {
                connection = dataSource.getConnection("ITSOL", "12345");
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

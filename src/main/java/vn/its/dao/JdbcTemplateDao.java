package vn.its.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.its.model.Student;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component("jdbcTemplateDao")
public class JdbcTemplateDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertStudent(Student student) {
        String sql = "insert into student values (" + student.getId() + ",'" + student.getName() + "','" + student.getLocation() + "')";
        jdbcTemplate.execute(sql);
    }

    public void deleteStudent() {
        String sql = "DELETE FROM STUDENT";
        jdbcTemplate.execute(sql);
    }

    public int countStudents() {
        String sql = "SELECT COUNT (*) FROM STUDENT";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public String nameStudents() {
        String sql = "SELECT NAME FROM STUDENT";
        return jdbcTemplate.queryForObject(sql, String.class);
    }

    public List<Student> getAllStudent() {
        String sql = "select * from student";
        return jdbcTemplate.query(sql, new StudentMapper());
    }

    public Student getStudentById(int id){
        Student student = null;
        String sql = "SELECT * FROM STUDENT  WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new StudentMapper());
    }

    private static final class StudentMapper implements RowMapper<Student>{
        public Student mapRow(ResultSet resultSet, int arg1) throws SQLException{
            return new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("location"));
        }
    }

}

package vn.its.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import vn.its.model.Student;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("JdbcTemplateDaoSupport")
public class JdbcTemplateDaoSupport extends JdbcDaoSupport {

    public void insertStudent(Student student) {
        String sql = "insert into student values (" + student.getId() + ",'" + student.getName() + "','" + student.getLocation() + "')";
        this.getJdbcTemplate().execute(sql);
    }

    public Student getStudentById(int id){
        Student student = null;
        String sql = "SELECT * FROM STUDENT  WHERE ID = ?";
        return this.getJdbcTemplate().queryForObject(sql, new Object[] {id}, new StudentMapper());
    }

    public void deleteStudent() {
        String sql = "DELETE FROM STUDENT";
        this.getJdbcTemplate().execute(sql);
    }

    private static final class StudentMapper implements RowMapper<Student>{
        public Student mapRow(ResultSet resultSet, int arg1) throws SQLException{
            return new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("location"));
        }
    }

}

package vn.its;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vn.its.dao.JdbcTemplateDao;
import vn.its.model.Student;

public class StudentManagement {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        JdbcTemplateDao dao = context.getBean("jdbcTemplateDao", JdbcTemplateDao.class);
        dao.insertStudent(new Student(3, "tuan3", "ha noi3"));
        System.out.println(dao.getAllStudent());
    }
}

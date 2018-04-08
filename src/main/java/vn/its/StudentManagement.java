package vn.its;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vn.its.dao.JdbcTemplateDao;
import vn.its.dao.JdbcTemplateDaoSupport;
import vn.its.model.Student;

public class StudentManagement {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        JdbcTemplateDaoSupport dao = context.getBean("JdbcTemplateDaoSupport", JdbcTemplateDaoSupport.class);
        dao.insertStudent(new Student(1, "tuan", "ha noi"));
        System.out.println(dao.getStudentById(1));
        dao.deleteStudent();
    }
}

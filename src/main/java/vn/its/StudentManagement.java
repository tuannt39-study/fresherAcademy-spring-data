package vn.its;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vn.its.dao.StudentJdbcTemplateDao;
import vn.its.model.Student;

public class StudentManagement {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        StudentJdbcTemplateDao dao = context.getBean("studentJdbcTemplateDao", StudentJdbcTemplateDao.class);
        dao.insertStudent(new Student(2, "tuan2", "ha noi2"));
        System.out.println(dao.getAllStudent());
    }
}

package vn.its;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vn.its.dao.StudentJdbcDao;
import vn.its.model.Student;

public class StudentManagement {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        StudentJdbcDao dao = context.getBean("StudentJdbcDao", StudentJdbcDao.class);
        dao.insertStudent(new Student(1, "tuan", "ha noi"));
        System.out.println(dao.getAllStudent());
    }
}

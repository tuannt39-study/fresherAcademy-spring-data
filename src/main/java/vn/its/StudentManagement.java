package vn.its;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vn.its.model.Student;
import vn.its.service.StudentService;

public class StudentManagement {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        StudentHibernateDao dao = context.getBean("StudentHibernateDao", StudentHibernateDao.class);
//        dao.save(new Student(1, "Tuan", "Ha Noi"));

        StudentService studentService = context.getBean("studentService", StudentService.class);
        studentService.save(new Student(1, "Tuan1", "Ha Noi1"));

    }
}

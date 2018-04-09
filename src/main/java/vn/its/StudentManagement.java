package vn.its;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vn.its.dao.StudentHibernateDao;
import vn.its.model.Student;

public class StudentManagement {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        StudentHibernateDao dao = context.getBean("StudentHibernateDao", StudentHibernateDao.class);
        dao.save(new Student(1, "Tuan", "Ha Noi"));
    }
}

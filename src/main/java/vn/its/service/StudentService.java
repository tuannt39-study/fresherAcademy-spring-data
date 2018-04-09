package vn.its.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.its.dao.StudentHibernateDao;
import vn.its.model.Student;

@Service
public class StudentService {
    @Autowired
    private StudentHibernateDao studentHibernateDao;

    public void save(Student student){
        studentHibernateDao.save(student);
    }

}

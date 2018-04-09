package vn.its.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.its.model.Student;
import vn.its.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void test(){
        System.out.println(studentRepository.count());
        System.out.println(studentRepository.findAll());
        System.out.println(studentRepository.findByNameAndLocation("Tuan1", "Ha Noi1"));
        System.out.println(studentRepository.findByNameOrLocation("Nguyen Tuan", "Ha Noi2"));
        System.out.println(studentRepository.findFirstByOrderByNameAsc());

        System.out.println(studentRepository.getAllByNameAbc("Tuan1"));
    }
}

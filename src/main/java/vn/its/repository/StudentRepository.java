package vn.its.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.its.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByNameAndLocation(String name, String location);
    Student findByNameOrLocation(String name, String location);
    Student findFirstByOrderByNameAsc();


}

package vn.its.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.its.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByNameAndLocation(String name, String location);
    Student findByNameOrLocation(String name, String location);
    Student findFirstByOrderByNameAsc();

    @Query("select s from Student s where s.name = ?1")
    List<Student> getAllByNameAbc(String name);
}

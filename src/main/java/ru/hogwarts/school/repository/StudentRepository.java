package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {


    List<Student> findStudentByAge(int age);

    List<Student> findStudentByAgeBetween(int min, int max);



    @Query(value = "SELECT COUNT(id) FROM student",nativeQuery = true)
    Integer getStudentsAmount();

    @Query(value = "SELECT AVG(age) FROM student",nativeQuery = true)
    Double avgAgeStudent();

    @Query(value = "SELECT * FROM student order by id DESC LIMIT 5",nativeQuery = true)
    List<Student> lastFiveStudents();



}

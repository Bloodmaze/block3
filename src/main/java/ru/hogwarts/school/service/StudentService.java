package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;


@Service
public class StudentService {

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Faculty getStudentFaculty(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student not found"));
        return student.getFaculty();

    }

    public List<Student> filterByAge(Integer age) {
        return studentRepository.findStudentByAge(age);
    }


    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student not found"));
    }

    public Student updateUser(Student student) {
        return studentRepository.save(student);
    }

    public void deleteUser(long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findStudentByAgeBetween(Integer min, Integer max) {
        return studentRepository.findStudentByAgeBetween(min, max);
    }

}


package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
}


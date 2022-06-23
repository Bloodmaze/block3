package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/filter")
    public ResponseEntity <List<Student>> filterByAge(Integer age) {
        List<Student> listStudents = studentService.filterByAge(age);
       return ResponseEntity.ok(listStudents);

    }

    @PostMapping//POST
    public Student createStudent(Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("{id}") /// GET
    public ResponseEntity getStudent(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping//PUT
    public ResponseEntity<Student> editStudent(Student student) {
        Student student1 = studentService.updateUser(student);
        if (student1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student1);
    }

    @DeleteMapping("{id}")///DELETE
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteUser(id);
    }


}

package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
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
    public ResponseEntity<List<Student>> filterByAge(Integer age) {
        List<Student> listStudents = studentService.filterByAge(age);
        return ResponseEntity.ok(listStudents);

    }

    @GetMapping("/facultyStudents")
    public ResponseEntity<Faculty> getStudentFaculty(@RequestParam Long id) {
        return ResponseEntity.ok(studentService.getStudentFaculty(id));
    }


    @PostMapping//POST
    public Student createStudent(@RequestBody Student student) {
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

    @GetMapping
    public ResponseEntity<List<Student>> findStudentByAgeBetween(Integer min, Integer max) {
        List<Student> students = studentService.findStudentByAgeBetween(min, max);
        if (students.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(students);
    }

    @PutMapping//PUT
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
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

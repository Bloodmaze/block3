package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @GetMapping("/getFacultyLongName")
    public ResponseEntity getFacultyLongName() {
        try {
            return ResponseEntity.ok(facultyService.getFacultyLongName());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/getSum/{variants}")
    public ResponseEntity getSum(@PathVariable Integer variants) {
        return ResponseEntity.ok(facultyService.getSum(variants));
    }


    @GetMapping()
    public ResponseEntity<List<Student>> getFacultyStudent(@RequestParam Long id) {
        return ResponseEntity.ok(facultyService.getFacultyStudent(id));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Faculty>> findFacultyByNameOrColor(@RequestParam(required = false) String nameOrColor) {
        if (nameOrColor != null && !nameOrColor.isBlank()) {
            return ResponseEntity.ok(facultyService.findFacultyByNameOrColor(nameOrColor));
        }

        return ResponseEntity.ok(facultyService.getAllFaculty());
    }


    @PostMapping//POST
    public Faculty createFaculty(@RequestBody Faculty faculty) {

        return facultyService.createFaculty(faculty);
    }

    @GetMapping("/{id}") /// GET
    public ResponseEntity<Faculty> getStudent(@PathVariable Long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping//PUT
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty faculty1 = facultyService.updateFaculty(faculty);
        if (faculty1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty1);
    }

    @DeleteMapping("/{id}")///DELETE
    public void deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
    }
}

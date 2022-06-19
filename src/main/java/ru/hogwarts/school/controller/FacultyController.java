package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Faculty>> filterByColor(String color) {
        List<Faculty> listFaculty = facultyService.filterByColor(color);
        return ResponseEntity.ok(listFaculty);
    }


    @PostMapping//POST
    public Faculty createFaculty(Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("{id}") /// GET
    public ResponseEntity getStudent(@PathVariable Long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping//PUT
    public ResponseEntity<Faculty> editFaculty(Faculty faculty) {
        Faculty faculty1 = facultyService.updateFaculty(faculty);
        if (faculty1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty1);
    }

    @DeleteMapping("{id}")///DELETE
    public Faculty deleteFaculty(@PathVariable Long id) {
        return facultyService.deleteFaculty(id);
    }
}

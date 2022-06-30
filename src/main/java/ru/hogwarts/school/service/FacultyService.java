package ru.hogwarts.school.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;


import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;


    @Autowired

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Student> getFacultyStudent(Long id) {
        Faculty faculty = facultyRepository.findById(id).orElseThrow(() -> new NotFoundException("Faculty not found"));
        return faculty.getStudents();
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new NotFoundException("Faculty not found"));
    }

    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public List<Faculty> findFacultyByNameOrColor(String nameOrColor) {

            return facultyRepository.findFacultyByNameIgnoreCaseOrColorIgnoreCase(nameOrColor,nameOrColor);
        }

    }







package ru.hogwarts.school.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(FacultyService.class);


    @Autowired

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Student> getFacultyStudent(Long id) {
        logger.info("A method was called to get faculty by id");
        Faculty faculty = facultyRepository.findById(id).orElseThrow(() -> new NotFoundException("Faculty not found"));
        return faculty.getStudents();
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.info("A method was called to create a faculty");
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new NotFoundException("Faculty not found"));
    }

    public Faculty updateFaculty(Faculty faculty) {
        logger.info("A method was called to update the faculty");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        logger.info("A method was called to delete the faculty by id");
        facultyRepository.deleteById(id);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public List<Faculty> findFacultyByNameOrColor(String nameOrColor) {
        logger.info("A method was called to get faculties by name or color");

            return facultyRepository.findFacultyByNameIgnoreCaseOrColorIgnoreCase(nameOrColor,nameOrColor);
        }

    }







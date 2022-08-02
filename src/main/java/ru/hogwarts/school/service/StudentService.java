package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final Logger logger = LoggerFactory.getLogger(StudentService.class);


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void printStudentNames() {
        final List<String> list = studentRepository.findAll().stream()
                .map(Student::getName).toList();

        System.out.println(list.get(0));
        System.out.println(list.get(1));


        new Thread(() -> {
            System.out.println(list.get(2));
            System.out.println(list.get(3));
        }).start();

        new Thread(() -> {
            System.out.println(list.get(4));
            System.out.println(list.get(5));
        }).start();


    }

    public void printStudentNamesSync() {
        run(0);
        run(1);


        new Thread(() -> {
            run(2);
            run(3);
        }).start();

        new Thread(() -> {
            run(4);
            run(5);
        }).start();


    }

    private synchronized void run(int id) {
        String students = studentRepository.findAll().get(id).getName();

        System.out.println(students);
    }

    public List<String> getStudentsWithNameStartsA() {
        return studentRepository.findAll().stream()
                .map(a -> a.getName().toUpperCase())
                .filter(a -> a.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());
    }

    public double getAverageAgeByStream() {
        return studentRepository.findAll().stream()
                .mapToDouble(Student::getAge)
                .average().orElseThrow();
    }


    public Integer getStudentsAmount() {
        logger.info("A method was called to number of students");
        return studentRepository.getStudentsAmount();

    }

    public Double avgAgeStudent() {
        logger.info("A method was called to get average students age");

        return studentRepository.avgAgeStudent();
    }

    public List<Student> lastFiveStudents() {
        logger.info("A method was called to get last five students");
        return studentRepository.lastFiveStudents();
    }

    public Faculty getStudentFaculty(Long id) {

        logger.info("A method was called to get student by id");
        Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student not found"));
        return student.getFaculty();

    }

    public List<Student> filterByAge(Integer age) {
        logger.info("A method was called to get students by age");
        return studentRepository.findStudentByAge(age);
    }


    public Student createStudent(Student student) {
        logger.info("A method was called to add a student");
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        logger.info("A method was called to student by id");
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student not found"));
    }

    public Student updateUser(Student student) {
        logger.info("A method was called to update the student");
        return studentRepository.save(student);
    }

    public void deleteUser(long id) {
        logger.info("A method was called to delete the student by id");
        studentRepository.deleteById(id);
    }

    public List<Student> findStudentByAgeBetween(Integer min, Integer max) {
        logger.info("A method was called to get students by age interval");

        return studentRepository.findStudentByAgeBetween(min, max);
    }


}


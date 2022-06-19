package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final HashMap<Long, Student> studentMap = new HashMap<>();

    private long lastId = 0;

    public List<Student> filterByAge(Integer age) {
        return studentMap.values().stream().filter(student -> student.getAge() == age).collect(Collectors.toList());

    }


    public Student createStudent(Student student) {
        student.setId(++lastId);
        studentMap.put(lastId, student);
        return student;
    }

    public Student findStudent(long id) {
        return studentMap.get(id);
    }

    public Student updateUser(Student student) {
        if (studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
            return student;
        }
        return null;}

        public Student deleteUser(long id){
            return studentMap.remove(id);
        }
    }


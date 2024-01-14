package ru.gb;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping("/students/all")
    public List<Student> studentList(){
        return studentRepository.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getById(@PathVariable long id){
        return studentRepository.getStudentById(id);
    }

    @GetMapping
    public Student getByName(@RequestParam String name){
        return studentRepository.getStudentByName(name);
    }

    @GetMapping("/group/{groupName}/student")
    public List<Student> getStudentsByGroup(@PathVariable String groupName) {
        return studentRepository.getStudentByGroup(groupName);
    }

    @GetMapping("/student/search/%{name}%")
    public List<Student> getSearchStudents(@RequestParam String name) {
        return studentRepository.getSearchByName(name);
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.addStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteStudent(id);
    }
}

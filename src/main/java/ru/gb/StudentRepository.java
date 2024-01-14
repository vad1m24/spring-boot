package ru.gb;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class StudentRepository {

    List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        students.add(new Student("Vadim", "chemistry"));
        students.add(new Student("Sasha", "chemistry"));
        students.add(new Student("Igor", "chemistry"));
        students.add(new Student("Student #4", "math"));
        students.add(new Student("Student #5", "math"));
        students.add(new Student("Student #6", "math"));
        students.add(new Student("Student #7", "math"));
        students.add(new Student("Student #8", "language"));
        students.add(new Student("Student #9", "language"));
        students.add(new Student("Student #10", "language"));
    }

    public List<Student> getAllStudents() {
        return List.copyOf(students);
    }

    public Student getStudentById(long id){
        return students.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public Student getStudentByName(String name){
        return students.stream()
                .filter(it -> Objects.equals(it.getName(), name))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getSearchByName(String name) {
        return students.stream().filter(it -> Objects.equals(it.getName(), name)).toList();
    }

    public List<Student> getStudentByGroup(String groupName){
        return students.stream()
                .filter(it -> Objects.equals(it.getGroupName(), groupName))
                .toList();
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public void deleteStudent(Long id) {
        students.removeIf(it -> Objects.equals(it.getId(), id));
    }
}

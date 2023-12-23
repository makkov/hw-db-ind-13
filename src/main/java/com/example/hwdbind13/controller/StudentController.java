package com.example.hwdbind13.controller;

import com.example.hwdbind13.dto.StudentDto;
import com.example.hwdbind13.model.Student;
import com.example.hwdbind13.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student create(@RequestBody StudentDto student) {
        return studentService.add(student.getName(), student.getAge());
    }

    @GetMapping
    public Student get(@RequestParam long id) {
        return studentService.get(id);
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentService.update(student.getId(), student.getName(), student.getAge());
    }

    @DeleteMapping
    public Student delete(@RequestParam long id) {
        return studentService.delete(id);
    }

    @GetMapping("/age-between")
    public List<Student> getWhenAgeBetween(@RequestParam Integer min, @RequestParam Integer max) {
        return studentService.getWhenAgeBetween(min, max);
    }

    @GetMapping("/count")
    public int getCount() {
        return studentService.getCount();
    }

    @GetMapping("/avg-age")
    public double getAvgAge() {
        return studentService.getAvgAge();
    }

    @GetMapping("/last-five")
    public List<Student> getLastFive() {
        return studentService.getLastFive();
    }

    @GetMapping("/names-start-with-a")
    public List<String> getAllNamesStartWithA() {
        return studentService.getAllNamesStartWithA();
    }

    @GetMapping("/avg-age-with-stream")
    public double getAvgAgeWithStream() {
        return studentService.getAvgAgeWithStream();
    }

    @GetMapping("/print-to-console")
    public void printStudents() {
        studentService.printStudents();
    }

    @GetMapping("/print-to-console-sync")
    public void printStudentsSync() {
        studentService.printStudentsSync();
    }
}

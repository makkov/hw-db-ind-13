package com.example.hwdbind13.controller;

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
    public Student create(@RequestBody Student student) {
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
}

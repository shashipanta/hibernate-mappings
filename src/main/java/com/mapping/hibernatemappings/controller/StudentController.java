package com.mapping.hibernatemappings.controller;

import com.mapping.hibernatemappings.dto.request.StudentRequest;
import com.mapping.hibernatemappings.dto.response.StudentResponse;
import com.mapping.hibernatemappings.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

   private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/")
    public StudentResponse registerStudent(@RequestBody StudentRequest studentRequest){
        return studentService.createStudent(studentRequest);
    }

    @PutMapping("/{id}")
    public StudentResponse updateStudent(@PathVariable("id") Short studentId, @RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(studentId, studentRequest);
    }

    @GetMapping("/")
    public List<StudentResponse> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponse getSingleStudent(@PathVariable("id") Short studentId){
        return studentService.getSingleStudent(studentId);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") Short studentId){
        studentService.deleteStudent(studentId);
        return "deleted";
    }
}

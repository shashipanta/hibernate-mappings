package com.mapping.hibernatemappings.service.serviceImpl;

import com.mapping.hibernatemappings.dto.request.StudentRequest;
import com.mapping.hibernatemappings.dto.response.StudentResponse;
import com.mapping.hibernatemappings.entity.Student;
import com.mapping.hibernatemappings.repo.StudentRepo;
import com.mapping.hibernatemappings.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        Student student = StudentRequest.toStudent(studentRequest);
        student = studentRepo.save(student);
        return StudentResponse.toStudentResponse(student);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        List<Student> studentList = studentRepo.findAll();
        return studentList.stream()
                            .map(StudentResponse::toStudentResponse)
                            .collect(Collectors.toList());
    }

    @Override
    public StudentResponse getSingleStudent(Short studentId) {
        Student student = studentRepo.findById(studentId).orElseThrow();

        return StudentResponse.toStudentResponse(student);
    }

    @Override
    public StudentResponse updateStudent(Short studentId, StudentRequest studentRequest) {

        Student foundStudent = studentRepo.findById(studentId).orElseThrow();

        foundStudent = StudentRequest.toStudent(foundStudent, studentRequest);

        foundStudent = studentRepo.save(foundStudent);

        return StudentResponse.toStudentResponse(foundStudent);
    }

    @Override
    public void deleteStudent(Short studentId) {
        studentRepo.deleteById(studentId);
    }
}

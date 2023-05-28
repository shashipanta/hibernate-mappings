package com.mapping.hibernatemappings.service;

import com.mapping.hibernatemappings.dto.request.StudentRequest;
import com.mapping.hibernatemappings.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse createStudent(StudentRequest studentRequest);

    List<StudentResponse> getAllStudents();

    StudentResponse getSingleStudent(Short studentId);

    StudentResponse updateStudent(Short studentId, StudentRequest studentRequest);

    void deleteStudent(Short studentId);

}

package com.mapping.hibernatemappings.dto.request;

import com.mapping.hibernatemappings.entity.Student;

public record StudentRequest(
        Short id,
        String name,
        String address,
        String email
) {


    // to save student into db
    public static Student toStudent(StudentRequest studentRequest){
        Student student = new Student();

        student.setName(studentRequest.name());
        student.setAddress(studentRequest.address());
        student.setEmail(studentRequest.email());

        return student;
    }

    // to update student into db
    public static Student toStudent(Student foundStudent, StudentRequest studentRequest){
        if(studentRequest.id() != null) foundStudent.setId(studentRequest.id());
        if(studentRequest.name() != null) foundStudent.setName(studentRequest.name());
        if(studentRequest.address() != null) foundStudent.setAddress(studentRequest.address());
        if(studentRequest.email() != null) foundStudent.setEmail(studentRequest.email());
        return foundStudent;
    }
}

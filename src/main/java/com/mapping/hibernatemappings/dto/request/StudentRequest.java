package com.mapping.hibernatemappings.dto.request;

import com.mapping.hibernatemappings.entity.Phone;
import com.mapping.hibernatemappings.entity.Student;

import java.util.List;

public record StudentRequest(
        Short id,
        String name,
        String address,
        String email,
        List<Phone> phoneList
) {


    // to save student into db
    public static Student toStudent(StudentRequest studentRequest){
        Student student = new Student();

        student.setName(studentRequest.name());
        student.setAddress(studentRequest.address());
        student.setEmail(studentRequest.email());
        student.setPhone(studentRequest.phoneList());

        return student;
    }

    // to update student into db
    public static Student toStudent(Student foundStudent, StudentRequest studentRequest){
        if(studentRequest.id() != null) foundStudent.setId(studentRequest.id());
        if(studentRequest.name() != null) foundStudent.setName(studentRequest.name());
        if(studentRequest.address() != null) foundStudent.setAddress(studentRequest.address());
        if(studentRequest.email() != null) foundStudent.setEmail(studentRequest.email());
        if(studentRequest.phoneList() != null) foundStudent.setPhone(studentRequest.phoneList());
        return foundStudent;
    }
}

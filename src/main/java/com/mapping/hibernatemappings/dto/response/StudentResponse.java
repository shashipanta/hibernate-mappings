package com.mapping.hibernatemappings.dto.response;

import com.mapping.hibernatemappings.entity.Phone;
import com.mapping.hibernatemappings.entity.Student;

import java.util.List;

public record StudentResponse(
        Short id,
        String name,
        String address,
        String email,
        List<Phone> phone
) {

    public static StudentResponse toStudentResponse(Student student){
        return new StudentResponse(student.getId(), student.getName(), student.getAddress(), student.getEmail(), student.getPhone());
    }
}

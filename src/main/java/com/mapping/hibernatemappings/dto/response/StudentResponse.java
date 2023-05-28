package com.mapping.hibernatemappings.dto.response;

import com.mapping.hibernatemappings.entity.Student;

public record StudentResponse(
        Short id,
        String name,
        String address,
        String email
) {

    public static StudentResponse toStudentResponse(Student student){
        return new StudentResponse(student.getId(), student.getName(), student.getAddress(), student.getEmail());
    }
}

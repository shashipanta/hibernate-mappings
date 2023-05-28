package com.mapping.hibernatemappings.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_student_email", columnNames = "stu_email")
    }
)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "stu_name", length = 100, nullable = false)
    private String name;

    @Column(name = "stu_address", length = 100)
    private String address;

    @Column(name = "stu_email", length = 150, nullable = false)
    private String email;

}

package com.mapping.hibernatemappings.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "user_tbl",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_email", columnNames = "email")
    }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String userId;
    private String name;
    private String password;
    private String email;
    private Address address;
}

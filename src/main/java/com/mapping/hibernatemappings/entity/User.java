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
    @Column(name = "id")
    private String userId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToOne(targetEntity = Address.class, fetch = FetchType.EAGER)
    private Address address;
}

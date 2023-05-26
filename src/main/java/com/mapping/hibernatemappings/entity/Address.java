package com.mapping.hibernatemappings.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permanent", nullable = false)
    private String permanentAddress;

    @Column(name = "temporary")
    private String temporaryAddress;


}
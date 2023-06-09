package com.mapping.hibernatemappings.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_address_id", columnNames = {"id"})
        }
)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permanent", nullable = false)
    private String permanentAddress;

    @Column(name = "temporary")
    private String temporaryAddress;

}

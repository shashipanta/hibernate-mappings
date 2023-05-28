package com.mapping.hibernatemappings.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phone",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_phone_primary", columnNames = "ph_primary"),
                @UniqueConstraint(name = "uk_phone_secondary", columnNames = "ph_secondary")
        }
)
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "ph_primary", length = 10, nullable = false)
    private String primary;

    @Column(name = "ph_secondary", length = 10)
    private String secondary;

    // Many phone can be associated to one Student

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_phone_studentId")
    )
    private Student student;
}

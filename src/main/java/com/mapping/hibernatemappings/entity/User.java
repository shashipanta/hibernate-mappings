package com.mapping.hibernatemappings.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_tbl",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_user_address", columnNames = "address_id"),
                @UniqueConstraint(name = "uk_user_email", columnNames = "email"),
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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id",
            foreignKey = @ForeignKey(name = "fk_user_addressId"),
            unique = true,
            referencedColumnName = "id"
    )
//    @PrimaryKeyJoinColumn(name = "uk_address_id")
    private Address address;
}

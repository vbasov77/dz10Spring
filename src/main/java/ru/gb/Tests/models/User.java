package ru.gb.Tests.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(nullable = false)
    private String roles;

}

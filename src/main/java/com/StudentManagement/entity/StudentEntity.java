package com.StudentManagement.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "email", unique = true)
    @NotNull(message = "email is mandatory")
    private String email;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "place")
    private String address;

    @Column(name = "guardian")
    private String guardian;

    @Column(name = "batch")
    private String batch;

}

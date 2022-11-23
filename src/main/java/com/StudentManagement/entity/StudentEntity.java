package com.StudentManagement.entity;

import com.StudentManagement.utils.Messages;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "student")
public class StudentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "email", unique = true)
    @NotNull(message = "email is mandatory")
    @Email(message = Messages.EMAIL_INVALID)
    private String email;

    @Column(name = "phone", length = 10)
    private Long phone;

    @Column(name = "place", length = 40)
    private String address;

    @Column(name = "guardian", length = 30)
    private String guardian;

    @Column(name = "batch", length = 8)
    private Long batch;

}

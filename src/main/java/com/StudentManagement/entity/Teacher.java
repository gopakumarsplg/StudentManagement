package com.StudentManagement.entity;

import com.StudentManagement.entity.listeners.EntityListener;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Table(name = "tb_teachers")
@Entity
@EntityListeners(EntityListener.class)
public class Teacher extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "email", length = 60, unique = true, nullable = false)
    @Email
    private String email;

    @Column(name = "phone", length = 10)
    private int phone;

    @Column(name = "place", length = 30)
    private String place;

    @Column(name = "address", length = 60)
    private String address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_sub_id", referencedColumnName = "id")
    private Subject subject;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_class_id", referencedColumnName = "id")
    private Class classTable;
}

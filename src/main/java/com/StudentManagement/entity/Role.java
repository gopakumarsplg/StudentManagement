package com.StudentManagement.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_role")
@EntityListeners(EntityListeners.class)
public class Role extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;
}

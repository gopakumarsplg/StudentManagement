package com.StudentManagement.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_user")
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(name="tb_user_role",
            joinColumns={@JoinColumn(name="user_id"}, inverseJoinColumns={@JoinColumn(name="role_id")} )
                private Role roleId;
}

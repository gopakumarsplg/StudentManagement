package com.StudentManagement.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "fk_user_id")
    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "fk_role_id")
    @OneToOne(targetEntity = Role.class, fetch = FetchType.LAZY)
    private Role role;

    public UserRole (User user, Role role){
        this.role = role;
        this.user = user;
    }
}

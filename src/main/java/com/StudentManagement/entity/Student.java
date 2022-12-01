package com.StudentManagement.entity;

import com.StudentManagement.entity.listeners.EntityListener;
import com.StudentManagement.utils.Messages;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "tb_student")
@Where(clause = "deleted = false")
@EntityListeners(EntityListener.class)
public class Student extends BaseEntity {

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
    private int phone;

    @Column(name = "place", length = 40)
    private String address;

    @Column(name = "guardian", length = 30)
    private String guardian;

    @Column(name = "batch", length = 8)
    private int batch;

    @Column(name = "deleted")
    private Boolean isDeleted;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Class classId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;

}

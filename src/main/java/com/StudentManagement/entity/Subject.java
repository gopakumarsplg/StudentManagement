package com.StudentManagement.entity;

import com.StudentManagement.entity.listeners.EntityListener;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_subjects")
@EntityListeners(EntityListener.class)
public class Subject extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToOne(mappedBy = "subject")
    private Long id;

    @Column(name = "name", length = 30)
    private String subject;
}

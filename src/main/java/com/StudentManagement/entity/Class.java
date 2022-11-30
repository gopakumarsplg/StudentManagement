package com.StudentManagement.entity;

import com.StudentManagement.entity.listeners.EntityListener;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_class")
@EntityListeners(EntityListener.class)
public class Class extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToOne(mappedBy = "classTable")
    private Long id;

    @Column(name = "standard", length = 16)
    private int standard;

}

package com.StudentManagement.entity;

import com.StudentManagement.entity.listeners.EntityListener;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_exams")
@EntityListeners(EntityListener.class)
public class Exam extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", length = 30)
    private String type;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_subject_id", referencedColumnName = "id")
    private Subject subject;

    @Column(name = "marks")
    private Integer marks;

    @Column(name = "grade", length = 1)
    private String garde;

}

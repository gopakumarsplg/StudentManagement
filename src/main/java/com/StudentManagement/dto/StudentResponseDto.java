package com.StudentManagement.dto;

import com.StudentManagement.entity.Class;
import com.StudentManagement.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto extends BaseDto{

    private String name;

    private String email;

    private int phone;

    private String address;

    private String guardian;

    private int batch;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Class classId;

    public StudentResponseDto(Student savedEntity) {
        BeanUtils.copyProperties(savedEntity, this);
    }
}

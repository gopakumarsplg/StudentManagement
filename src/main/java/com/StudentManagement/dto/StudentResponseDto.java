package com.StudentManagement.dto;

import com.StudentManagement.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

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

    private String username;
    private ClassDto data;

    public StudentResponseDto(Student savedEntity, String username) {
        BeanUtils.copyProperties(savedEntity, this);
        ClassDto classDto = new ClassDto(savedEntity.getClassId());
        this.data = classDto;
        this.username = username;
    }
}

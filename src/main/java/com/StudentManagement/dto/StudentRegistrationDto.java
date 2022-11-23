package com.StudentManagement.dto;

import com.StudentManagement.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegistrationDto {

    private String name;
    private String email;
    private Long phone;
    private String address;
    private String guardian;
    private Long batch;

    public StudentRegistrationDto(StudentEntity studentEntity) {
        this.name = studentEntity.getName();
        this.email = studentEntity.getName();
        this.phone = studentEntity.getPhone();
        this.address = studentEntity.getAddress();
        this.guardian = studentEntity.getGuardian();
        this.batch = studentEntity.getBatch();
    }
}

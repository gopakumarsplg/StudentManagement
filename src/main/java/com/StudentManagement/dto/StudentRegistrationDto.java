package com.StudentManagement.dto;

import com.StudentManagement.entity.Student;
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

    public StudentRegistrationDto(Student student) {
        this.name = student.getName();
        this.email = student.getName();
        this.phone = student.getPhone();
        this.address = student.getAddress();
        this.guardian = student.getGuardian();
        this.batch = student.getBatch();
    }
}

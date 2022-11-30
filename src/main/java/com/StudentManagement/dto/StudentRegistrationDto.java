package com.StudentManagement.dto;

import com.StudentManagement.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegistrationDto extends BaseDto {

    private String name;
    private String email;
    private int phone;
    private String address;
    private String guardian;
    private int batch;

    private String password;

    private Long classId;

    public StudentRegistrationDto(Student student) {
        this.name = student.getName();
        this.email = student.getName();
        this.phone = student.getPhone();
        this.address = student.getAddress();
        this.guardian = student.getGuardian();
        this.batch = student.getBatch();
    }
}

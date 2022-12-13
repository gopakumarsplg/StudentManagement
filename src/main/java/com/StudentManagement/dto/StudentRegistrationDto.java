package com.StudentManagement.dto;

import com.StudentManagement.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegistrationDto extends BaseDto {

    @NotEmpty(message = "#name.is.empty")
    private String name;
    @NotNull(message = "#email.is.empty")
    private String email;

    @NotNull(message = "#phone.is.empty")
    private Integer phone;

    @NotNull(message = "#address.is.empty")
    private String address;
    private String guardian;
    private int batch;

    @NotNull(message = "#password.is.empty")
    private String password;

    private Long classId;

    @NotNull(message = "#user.name.is.empty")
    private String username;

    private ArrayList<Long> roleId;

    public StudentRegistrationDto(Student student) {
        this.name = student.getName();
        this.email = student.getName();
        this.phone = student.getPhone();
        this.address = student.getAddress();
        this.guardian = student.getGuardian();
        this.batch = student.getBatch();
    }
}

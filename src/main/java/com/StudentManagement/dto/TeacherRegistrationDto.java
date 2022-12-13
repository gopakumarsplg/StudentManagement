package com.StudentManagement.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
public class TeacherRegistrationDto extends BaseDto{

    @NotEmpty(message = "#name.is.empty")
    private String name;

    @NotNull(message = "#email.is.empty")
    private String email;

    @NotNull(message = "#phone.is.empty")
    private Long phone;

    @NotEmpty(message = "#phone.is.empty")
    private String place;

    @NotEmpty(message = "#address.is.empty")
    private String address;

    @NotNull(message = "#subject.id.is.empty")
    private Long subjectId;

    @NotNull(message = "#class.id.is.empty")
    private Long classId;

    @NotEmpty(message = "#user.name.is.empty")
    private String userName;

    @NotEmpty(message = "#password.is.empty")
    private String password;

    @NotEmpty(message = "#role.is.empty")
    private ArrayList<Long> roleId;
}

package com.StudentManagement.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class TeacherRegistrationDto extends BaseDto{

    @NotEmpty
    private String name;

    @NotNull
    private String email;

    @NotNull
    private Long phone;

    @NotEmpty
    private String place;

    @NotEmpty
    private String address;

    @NotNull
    private Long subject_id;

    @NotNull
    private Long class_id;
}

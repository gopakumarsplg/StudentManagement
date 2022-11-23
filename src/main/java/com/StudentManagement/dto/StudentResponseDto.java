package com.StudentManagement.dto;

import com.StudentManagement.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto extends RestApiResponse{
    private StudentEntity data;
}

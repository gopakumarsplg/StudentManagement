package com.StudentManagement.repository;

import com.StudentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select * from tb_student ts where \n" +
            "ts.user_id =:userId", nativeQuery = true)
    Optional<Student> findByUserId(Long userId);
}

package com.StudentManagement.repository;

import com.StudentManagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "select * from tb_role r \n" +
            "join tb_student ts on ts.role_id = r.id \n" +
            "where ts.id = :id",nativeQuery = true)
    List<Role> findAllRolesByUser(Long id);
}

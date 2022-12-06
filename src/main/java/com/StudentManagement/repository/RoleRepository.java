package com.StudentManagement.repository;

import com.StudentManagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "select * from tb_user_role tur\n" +
            "join tb_role tr on tr.id = tur.fk_role_id \n" +
            "where tur.fk_user_id = ?1",nativeQuery = true)
    List<Role> findAllRolesByUser(Long userId);
}

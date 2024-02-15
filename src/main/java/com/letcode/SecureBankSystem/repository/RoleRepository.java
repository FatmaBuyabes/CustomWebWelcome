package com.letcode.SecureBankSystem.repository;

import com.letcode.SecureBankSystem.entity.RoleEntity;
import com.letcode.SecureBankSystem.util.enums.roles.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByTitle(Roles title);

    @Query(value = "SELECT * FROM role r where r.title = :title", nativeQuery = true)
    Optional<RoleEntity> findRoleEntityByTitle(String title);
}

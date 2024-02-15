package com.letcode.SecureBankSystem.repository;

import com.letcode.SecureBankSystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> { //extend from library


    Optional<UserEntity> findByUsername(String username);

}

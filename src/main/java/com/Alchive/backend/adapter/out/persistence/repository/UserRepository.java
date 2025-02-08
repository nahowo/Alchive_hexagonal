package com.Alchive.backend.adapter.out.persistence.repository;

import com.Alchive.backend.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserEntityByEmail(String email);
    Optional<UserEntity> findUserEntityByName(String email);
    Boolean existsUserEntityByEmail(String email);
    Boolean existsUserEntityByName(String name);
    @Modifying(clearAutomatically = true)
    @Query("UPDATE UserEntity userEntity SET userEntity.description = :description, userEntity.autoSave = :autoSave WHERE userEntity.id = :id")
    void updateUser(@Param(value = "description") String description, @Param(value = "autoSave") Boolean autoSave, @Param(value = "id") Long id);
}

package com.ravaan.techky.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravaan.techky.spring.dto.User;

/**
 * The Interface UserJpaRepository.
 */
@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {

}

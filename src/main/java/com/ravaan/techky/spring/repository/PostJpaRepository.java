package com.ravaan.techky.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravaan.techky.spring.dto.Post;

public interface PostJpaRepository extends JpaRepository<Post, Integer>{

}

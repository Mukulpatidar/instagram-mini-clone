package com.smart.instagram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.instagram.model.Post;
import com.smart.instagram.model.User;

public interface PostRepository extends JpaRepository<Post, Long> {

    // Feed feature ke liye
    List<Post> findByUserIn(List<User> users);
}
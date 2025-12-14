package com.smart.instagram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.instagram.model.Follow;
import com.smart.instagram.model.User;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    // Find all follow records for a user
    List<Follow> findByFollower(User follower);
}

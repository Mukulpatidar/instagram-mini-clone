package com.smart.instagram.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart.instagram.service.FollowService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final FollowService followService;

    public UserController(FollowService followService) {
        this.followService = followService;
    }

    // POST /api/users/{id}/follow
    @PostMapping("/{id}/follow")
    public ResponseEntity<String> followUser(
            @PathVariable Long id,
            @RequestParam Long followerId // TEMP (JWT later)
    ) {
        followService.followUser(followerId, id);
        return ResponseEntity.ok("User followed successfully");
    }
}

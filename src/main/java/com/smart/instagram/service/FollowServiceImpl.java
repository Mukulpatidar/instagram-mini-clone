package com.smart.instagram.service;

import org.springframework.stereotype.Service;

import com.smart.instagram.model.Follow;
import com.smart.instagram.model.User;
import com.smart.instagram.repository.FollowRepository;
import com.smart.instagram.repository.UserRepository;

@Service
public class FollowServiceImpl implements FollowService {
	
	 private final FollowRepository followRepository;
	    private final UserRepository userRepository;

	    public FollowServiceImpl(FollowRepository followRepository, UserRepository userRepository) {
	        this.followRepository = followRepository;
	        this.userRepository = userRepository;
	    }

	@Override
	public void followUser(Long followerId, Long followingId) {
		
		if (followerId.equals(followingId)) {
            throw new RuntimeException("User cannot follow himself");
        }

        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Follower not found"));

        User following = userRepository.findById(followingId)
                .orElseThrow(() -> new RuntimeException("Following user not found"));

        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowing(following);

        followRepository.save(follow);
		
	}

}

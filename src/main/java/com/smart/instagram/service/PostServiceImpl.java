package com.smart.instagram.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.smart.instagram.model.Follow;
import com.smart.instagram.model.Post;
import com.smart.instagram.model.User;
import com.smart.instagram.repository.FollowRepository;
import com.smart.instagram.repository.PostRepository;
import com.smart.instagram.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService{

	
	 private final PostRepository postRepository;
	    private final UserRepository userRepository;
	    private final FollowRepository followRepository;

	    public PostServiceImpl(PostRepository postRepository,
	                           UserRepository userRepository,
	                           FollowRepository followRepository) {
	        this.postRepository = postRepository;
	        this.userRepository = userRepository;
	        this.followRepository = followRepository;
	    }
	    
	    
	@Override
	public Post createPost(Post post, Long userId) {
		User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        post.setUser(user);
        return postRepository.save(post);
    }
	

	@Override
	public List<Post> getFeed(Long currentUserId) {
	
		User currentUser = userRepository.findById(currentUserId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Step 1: get users current user follows
        List<Follow> follows = followRepository.findByFollower(currentUser);

        List<User> followedUsers = follows.stream()
                .map(Follow::getFollowing)
                .collect(Collectors.toList());

        // Step 2: fetch posts of followed users
        return postRepository.findByUserIn(followedUsers);
	}

}

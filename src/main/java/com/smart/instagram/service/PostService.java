package com.smart.instagram.service;

import java.util.List;

import com.smart.instagram.model.Post;


public interface PostService {

	 Post createPost(Post post, Long userId);

	    List<Post> getFeed(Long currentUserId);
}

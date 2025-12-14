package com.smart.instagram.model;
import java.time.LocalDateTime;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Post {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String imageUrl;
	    private String caption;

	    private LocalDateTime createdAt = LocalDateTime.now();

	    // Many posts → one user
	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;

	    // One post → many comments
	    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Comment> comments = new ArrayList<>();
	    
	    
	    
 // Likes will be added later (Phase-3)
	    
	    // Getters & Setters

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public String getCaption() {
			return caption;
		}

		public void setCaption(String caption) {
			this.caption = caption;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public List<Comment> getComments() {
			return comments;
		}

		public void setComments(List<Comment> comments) {
			this.comments = comments;
		}

	   
	    
	    
}

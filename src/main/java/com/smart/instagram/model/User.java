package com.smart.instagram.model;

import java.util.*;



import jakarta.persistence.*;


@Entity
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
    }
)

public class User {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String username;

	    @Column(nullable = false)
	    private String email;

	    @Column(nullable = false)
	    private String password;

	    private String profilePic;

	    // One user → many posts
	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Post> posts = new ArrayList<>();

	    // Followers
	    @OneToMany(mappedBy = "following")
	    private List<Follow> followers = new ArrayList<>();

	    // Following
	    @OneToMany(mappedBy = "follower")
	    private List<Follow> following = new ArrayList<>();
	    
	    
	    // Getters Setters

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getProfilePic() {
			return profilePic;
		}

		public void setProfilePic(String profilePic) {
			this.profilePic = profilePic;
		}

		public List<Post> getPosts() {
			return posts;
		}

		public void setPosts(List<Post> posts) {
			this.posts = posts;
		}

		public List<Follow> getFollowers() {
			return followers;
		}

		public void setFollowers(List<Follow> followers) {
			this.followers = followers;
		}

		public List<Follow> getFollowing() {
			return following;
		}

		public void setFollowing(List<Follow> following) {
			this.following = following;
		}

	   
	    
	    
}

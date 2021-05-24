package com.ravaan.techky.spring.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ravaan.techky.spring.dto.Post;
import com.ravaan.techky.spring.dto.User;
import com.ravaan.techky.spring.exception.ResourceNotFoundException;
import com.ravaan.techky.spring.repository.PostJpaRepository;
import com.ravaan.techky.spring.repository.UserJpaRepository;

/**
 * The Class UserJpaController.
 */
@RestController
public class UserJpaController {

	/** The user repository. */
	@Autowired
	private UserJpaRepository userRepository;

	/** The post repository. */
	@Autowired
	private PostJpaRepository postRepository;

	/**
	 * Gets the all user.
	 *
	 * @return the all user
	 */
	@GetMapping(path = "/jpa/user")
	public CollectionModel<User> getAllUser() {
		List<User> userList = this.userRepository.findAll();
		CollectionModel<User> resource = CollectionModel.of(userList);
		WebMvcLinkBuilder userLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findUser(123));
		resource.add(userLink.withRel("user-link"));
		WebMvcLinkBuilder deleteUserLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).deleteUser(123));
		resource.add(deleteUserLink.withRel("delete-user-link"));
		User userObject = new User(-1, "firstName", "lastName", "address");
		WebMvcLinkBuilder saveUserLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).saveUser(userObject));
		resource.add(saveUserLink.withRel("save-user-link"));
		return resource;
	}

	/**
	 * Find user.
	 *
	 * @param userId the user id
	 * @return the entity model
	 */
	@GetMapping(path = "/jpa/user/{userId}")
	public EntityModel<User> findUser(@PathVariable(name = "userId") Integer userId) {
		Optional<User> resultUser = this.userRepository.findById(userId);
		if (!resultUser.isPresent()) {
			throw new ResourceNotFoundException("Requested user not found. [User ID : " + userId + "]");
		}
		EntityModel<User> resource = EntityModel.of(resultUser.get());
		WebMvcLinkBuilder deleteUserLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).deleteUser(123));
		resource.add(deleteUserLink.withRel("delete-user-link"));
		WebMvcLinkBuilder allUserLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUser());
		resource.add(allUserLink.withRel("all-user"));
		return resource;
	}

	/**
	 * Save user.
	 *
	 * @param userObject the user object
	 * @return the response entity
	 */
	@PostMapping(path = "/jpa/user")
	public ResponseEntity<Object> saveUser(@Validated @RequestBody User userObject) {
		User newUser = this.userRepository.save(userObject);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
				.buildAndExpand(newUser.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}

	/**
	 * Delete user.
	 *
	 * @param userId the user id
	 * @return the response entity
	 */
	@DeleteMapping(path = "/jpa/user/{userId}")
	public ResponseEntity<Object> deleteUser(@PathVariable(name = "userId") Integer userId) {
		this.userRepository.deleteById(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Find posts.
	 *
	 * @param userId the user id
	 * @return the list
	 */
	@GetMapping(path = "/jpa/user/{userId}/posts")
	public List<Post> findPosts(@PathVariable(name = "userId") Integer userId) {
		Optional<User> resultUser = this.userRepository.findById(userId);
		if (!resultUser.isPresent()) {
			throw new ResourceNotFoundException("Requested user not found. [User ID : " + userId + "]");
		}
		return resultUser.get().getPosts();
	}

	/**
	 * Save user.
	 *
	 * @param userObject the user object
	 * @return the response entity
	 */
	@PostMapping(path = "/jpa/user/{userId}/posts")
	public ResponseEntity<Object> saveUser(@PathVariable Integer userId, @RequestBody Post post) {
		Optional<User> resultUser = this.userRepository.findById(userId);
		if (!resultUser.isPresent()) {
			throw new ResourceNotFoundException("Requested user not found. [User ID : " + userId + "]");
		}

		User userObject = resultUser.get();
		post.setUser(userObject);
		Post newPost = this.postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{postId}")
				.buildAndExpand(newPost.getPostId()).toUri();
		return ResponseEntity.created(location).build();
	}
}

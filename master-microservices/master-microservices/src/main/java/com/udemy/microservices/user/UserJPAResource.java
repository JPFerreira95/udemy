package com.udemy.microservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udemy.microservices.post.Post;
import com.udemy.microservices.post.PostRepository;

/**
 * The Class UserJPAResource.
 */
@RestController
public class UserJPAResource {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	/**
	 * Retreive all users.
	 *
	 * @return the list
	 */
	@GetMapping("/jpa/users")
	public List<User> retreiveAllUsers() {
		return userRepository.findAll();
	}

	/**
	 * Retrieve user.
	 *
	 * @param id the id
	 * @return the entity model
	 */
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {

		Optional<User> optUser = userRepository.findById(id);

		if (!optUser.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		// get the user
		User user = optUser.get();

		EntityModel<User> model = EntityModel.of(user);

		// vai buscar o link dentro desta class para um método em específico, neste caso
		// o "retreiveAllUsers"
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retreiveAllUsers());

		model.add(linkToUsers.withRel("all-users"));

		return model;
	}

	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {

		User savedUser = userRepository.save(user);

		// the status to return should be 201 created
		// it should return the uri to get the new user information - /user/{id}
		// in this case it will be /jpa/users/savedUser.getUd
		// this information will appear in the header of the response
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	/**
	 * Delete user.
	 * It should not send any Response Body, only the successful status.
	 *
	 * @param id the id
	 */
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {

		userRepository.deleteById(id);

		// another alternative to void
		// return ResponseEntity.noContent();
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePosts(@PathVariable int id) {

		Optional<User> optUser = userRepository.findById(id);

		if (!optUser.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		// get the user
		User user = optUser.get();

		return user.getPosts();
	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {

		Optional<User> optUser = userRepository.findById(id);

		if (!optUser.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		// get the user
		User user = optUser.get();

		post.setUser(user);

		Post savedPost = postRepository.save(post);

		// the status to return should be 201 created
		// it should return the uri to get the new user information - /user/{id}
		// in this case it will be /jpa/users/savedUser.getUd
		// this information will appear in the header of the response
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

}

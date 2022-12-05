package com.messagerie.M2e.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.messagerie.M2e.model.User;
import com.messagerie.M2e.service.UserDirectory;

@RestController
@RequestMapping("api")
public class UserController {
	@Autowired
	private UserDirectory userDirectory;

	@GetMapping("users")
	public List<User> getUsers() {

		return userDirectory.getUsers();
	}

	@GetMapping("users/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
		Optional<User> optionalUser = userDirectory.getUser(id);
		if (optionalUser.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(optionalUser.get());
		}
	}
//------------------------------------------------------------------------------------------

	@PostMapping("users")
	public User addUser(@RequestBody User newUser) {
		userDirectory.addUser(newUser);
		return newUser;
	}

	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		userDirectory.deleteUser(id);
	}

	@PutMapping("users/{id}")
	public ResponseEntity updateUser(@RequestBody User user, @PathVariable("id") Integer id) {
		if (id != user.getId()) {
			return ResponseEntity.badRequest().build();
		} else {
			userDirectory.updateUser(user, id);
			return ResponseEntity.ok().build();
		}

	}

	@PatchMapping("users/{id}")
	public void patchUser(@RequestBody User user, @PathVariable("id") Integer id) {
		System.out.println(user);
		userDirectory.patchUser(user, id);
	}

}

package com.messagerie.M2e.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.messagerie.M2e.dao.UserRepository;
import com.messagerie.M2e.model.User;

@Service
public class UserDirectory {
	@Autowired
	private UserRepository userRepository;

	public void addUser(User newUser) {
		userRepository.save(newUser);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUser(Integer id) {
		return userRepository.findById(id);

	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

	public void updateUser(User userToUpdate, Integer id) {
		userRepository.save(userToUpdate);
	}

	public void patchUser(User userToUpdate, Integer id) {
		Optional<User> op = userRepository.findById(id);
		if (op.isPresent()) {
			User user = op.get();
			user.patch(userToUpdate);
			userRepository.save(user);
		}
	}

}

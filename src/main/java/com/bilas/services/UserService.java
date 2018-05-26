package com.bilas.services;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bilas.modal.User;
import com.bilas.repository.UserRepository;

@Service
@Transactional
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void saveMyUser(User user) {
		userRepository.save(user);
	}

	public List<User> showAllUSers() {
		List<User> users = new ArrayList<User>();
		for (User user : userRepository.findAll()) {
			users.add(user);
		}
		return users;
	}

	public void deleteMyUser(int id) {
		userRepository.deleteById(id);
	}

	/*
	 * public User editUser(int id) { return userRepository.findById(id); }
	 */

	public User editUser(int id) {
		// Missing CrudRepository#findOne method
		// https://stackoverflow.com/questions/44101061/missing-crudrepositoryfindone-method/44103020#44103020s
		return userRepository.findById(id).orElse(null);
	}

	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

}
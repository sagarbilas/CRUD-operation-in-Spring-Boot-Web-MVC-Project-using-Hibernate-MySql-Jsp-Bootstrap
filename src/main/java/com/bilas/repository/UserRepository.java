package com.bilas.repository;

import org.springframework.data.repository.CrudRepository;

import com.bilas.modal.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUsernameAndPassword(String username,String  password);
}

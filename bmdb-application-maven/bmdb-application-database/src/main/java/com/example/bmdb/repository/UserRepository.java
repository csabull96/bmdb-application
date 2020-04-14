package com.example.bmdb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.bmdb.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findById(Long id);
	List<User> findByUsername(String username);
}

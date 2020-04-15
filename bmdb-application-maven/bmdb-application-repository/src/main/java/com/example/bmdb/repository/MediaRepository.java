package com.example.bmdb.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.example.bmdb.domain.Media;

public interface MediaRepository extends CrudRepository<Media, Long> {
	
	public Set<Media> findAll();
}

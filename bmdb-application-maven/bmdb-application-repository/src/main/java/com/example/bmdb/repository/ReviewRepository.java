package com.example.bmdb.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bmdb.domain.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {

}

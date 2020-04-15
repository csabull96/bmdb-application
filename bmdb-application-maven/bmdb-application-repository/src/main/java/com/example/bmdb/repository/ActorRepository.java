package com.example.bmdb.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bmdb.domain.Actor;

public interface ActorRepository extends CrudRepository<Actor, Long> {

}

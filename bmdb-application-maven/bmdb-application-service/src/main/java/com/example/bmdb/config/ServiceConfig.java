package com.example.bmdb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.example.bmdb.repository.CentralRepository;
import com.example.bmdb.service.Service;

@Configuration
@Import({CentralRepositoryConfig.class})
public class ServiceConfig {

	@Autowired
	private CentralRepository repository;
	
	@Bean
	public Service getService() {
		return new Service(repository);
	}
}

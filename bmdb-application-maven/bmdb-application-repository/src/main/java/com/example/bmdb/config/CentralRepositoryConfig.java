package com.example.bmdb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.bmdb.repository.CentralRepository;

@Configuration
public class CentralRepositoryConfig {

	@Bean
	public CentralRepository getCentralRepository() {
		return new CentralRepository();
	}
}

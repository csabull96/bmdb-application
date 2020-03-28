package com.example.bmdb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.bmdb.database.Database;

@Configuration
public class DatabaseConfig {

	@Bean
	public Database getDatabase() {
		return new Database();
	}
}

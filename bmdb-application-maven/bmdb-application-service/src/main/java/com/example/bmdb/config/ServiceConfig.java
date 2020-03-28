package com.example.bmdb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.example.bmdb.database.Database;
import com.example.bmdb.service.Service;

@Configuration
@Import({DatabaseConfig.class})
public class ServiceConfig {

	@Autowired
	private Database database;
	
	@Bean
	public Service getService() {
		return new Service(database);
	}
}

package com.example.bmdb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.example.bmdb.app.App;
import com.example.bmdb.app.View;
import com.example.bmdb.service.Service;

@Configuration
@PropertySource(value = {"classpath:config.properties"}, encoding = "UTF-8")
@Import({ServiceConfig.class, ViewConfig.class, SpringConfigurationDataSource.class, SpringConfigurationJpa.class})
public class AppConfig {
	
	@Autowired
	private Service service;
	
	@Autowired
	private View view;
	
	@Bean
	public App getApp() {
		return new App(service, view);
	}
}
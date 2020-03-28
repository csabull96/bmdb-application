package com.example.bmdb.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.example.bmdb.app.App;
import com.example.bmdb.app.View;
import com.example.bmdb.database.Database;
import com.example.bmdb.service.Service;

@Configuration
@PropertySource(value = {"classpath:config.properties"}, encoding = "UTF-8")
public class AppConfig {
	
	@Bean
	public App getApp() {
		return new App(getService(), getView());
	}
	
	@Bean
	public Service getService() {
		return new Service(getDatabase());
	}
	
	@Bean
	public Database getDatabase() {
		return new Database();
	}
	
	@Bean
	public View getView() {
		return new View();
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.addBasenames("messages/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
}
package com.example.bmdb.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.example.bmdb.app.View;

@Configuration
public class ViewConfig {

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

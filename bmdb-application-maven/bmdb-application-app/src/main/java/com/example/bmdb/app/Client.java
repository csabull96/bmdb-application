package com.example.bmdb.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.bmdb.app.App;
import com.example.bmdb.config.AppConfig;

public class Client {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            App app = appContext.getBean(App.class);       		
            app.play();
        }	
	}
}

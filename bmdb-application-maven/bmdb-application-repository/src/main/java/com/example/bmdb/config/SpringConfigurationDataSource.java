package com.example.bmdb.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfigurationDataSource {
	private static final String URL = "jdbc:mysql://localhost/bmdb_sandor_csaba?useSSL=false&useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "password";

	@Bean
	public DataSource dataSource() {
		return new DriverManagerDataSource(URL, USER, PASSWORD);
	}
}

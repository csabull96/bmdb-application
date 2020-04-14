package com.example.bmdb.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.bmdb.app.App;
import com.example.bmdb.config.AppConfig;
import com.example.bmdb.domain.User;

public class Client {
	public static void main(String[] args) throws SQLException {
		/*try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            App app = appContext.getBean(App.class);       		
            app.play();
        }*/	
		
		ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		/*DataSource dataSource = appContext.getBean(DataSource.class);
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select 1 + 1");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			resultSet.close();
			appContext.close();
			connection.close();
		}*/
          
		
		testJpa(appContext);
		
		
		
	}
	
	private static void testJpa(ApplicationContext context) {
		EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		User user = new User();
		user.setUsername("cs");
		user.setPassword("FakePassword");
		
		em.persist(user);
		tr.commit();
		System.out.println("user id: " + user.getId());
	}
}

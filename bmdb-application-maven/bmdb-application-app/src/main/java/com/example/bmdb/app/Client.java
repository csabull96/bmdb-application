package com.example.bmdb.app;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashSet;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.bmdb.app.App;
import com.example.bmdb.config.AppConfig;
import com.example.bmdb.domain.Actor;
import com.example.bmdb.domain.Media;
import com.example.bmdb.domain.MediaBuilder;
import com.example.bmdb.domain.Rating;
import com.example.bmdb.domain.Review;
import com.example.bmdb.domain.Sex;
import com.example.bmdb.domain.User;
import com.example.bmdb.repository.MediaRepository;
import com.example.bmdb.repository.ReviewRepository;
import com.example.bmdb.repository.UserRepository;

public class Client {
	public static void main(String[] args) throws SQLException {
		try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            App app = appContext.getBean(App.class);       		
            app.play();
		}	
	}
	
	private static void generateTestData(ApplicationContext context) {
		
		UserRepository userRepo = context.getBean(UserRepository.class);	
		Set<User> users = new HashSet<>();	
		User csabaSandor = new User("Csaba Sandor", "csabull96", "csaba.sandor@gmail.com", "password");
		User joelleHaddad = new User("Joelle Haddad", "joelle00", "joelle.haddad@gmail.com", "password");
		User stephenCurry = new User("Stephen Curry", "stephen89", "stephen.curry@gmail.com", "password");
		users.addAll(Arrays.asList(csabaSandor, joelleHaddad, stephenCurry));	
		userRepo.saveAll(users);
		
		Set<Actor> actors = new HashSet<>();
		Actor theRock = new Actor("Dwayne Johnson", new GregorianCalendar(1972, 5, 2), Sex.MALE, "Also known by his ring name The Rock, is an American actor, producer, businessman, and former professional wrestler[7] and football player");
		Actor nickJonas = new Actor("Nick Jerry Jonas", new GregorianCalendar(1992, 9, 16), Sex.MALE, "American singer, songwriter and actor.");
		Actor robCorddry = new Actor("Robert William Corddry", new GregorianCalendar(1971, 2, 4), Sex.MALE, "American actor and comedian.");
		Actor matthewMcConaughey = new Actor("Matthew McConaughey", new GregorianCalendar(1969, 11, 4), Sex.MALE, "American actor and producer.");
		Actor anneHathaway = new Actor("Anne Hathaway", new GregorianCalendar(1982, 11, 12), Sex.FEMALE, "American actress. The recipient of multiple awards, including an Academy Award, a Primetime Emmy Award, and a Golden Globe, she was one of the highest-paid actresses in the world in 2015.");
		Actor charlieHunnam = new Actor("Charles Matthew Hunnam", new GregorianCalendar(1980, 4, 10), Sex.MALE, "English actor.");
		Actor jenniferAniston = new Actor("Jennifer Joanna Aniston", new GregorianCalendar(1969, 2, 11), Sex.FEMALE, "American actress, film producer, and businesswoman. Aniston rose to international fame portraying Rachel Green on the television sitcom Friends, for which she earned Primetime Emmy, Golden Globe, and Screen Actors Guild awards.");
		Actor mattLeBlanc = new Actor("Matthew Steven LeBlanc", new GregorianCalendar(1967, 7, 25), Sex.MALE, "American actor and comedian. He is best known for his portrayal of dim-witted yet well-intentioned womaniser Joey Tribbiani in the NBC sitcom Friends and in its spin-off series Joey.");
		Actor matthewPerry = new Actor("Matthew Langford Perry", new GregorianCalendar(1969, 8, 19), Sex.MALE, "American-Canadian actor, comedian and playwright who gained worldwide recognition for his role as Chandler Bing on the NBC television sitcom Friends.");
		actors.addAll(Arrays.asList(theRock, nickJonas, robCorddry, matthewMcConaughey, anneHathaway, charlieHunnam, jenniferAniston, mattLeBlanc, matthewPerry));
		
		MediaRepository mediaRepo = context.getBean(MediaRepository.class);
		Set<Media> medias = new HashSet<>();	
		Media jumanji = new MediaBuilder().setTitle("Jumanji: Welcome to the Jungle")
				.setDescription("Four teenagers are sucked into a magical video game, and the only way they can escape is to work together to finish the game.")
				.setPremiereDate(new GregorianCalendar(2017, 12, 21))
				.addCastMember(theRock)
				.addCastMember(nickJonas)
				.getMovie();
		
		Media ballers = new MediaBuilder().setTitle("Ballers")
				.setDescription("A series centered around a group of football players and their families, friends and handlers.")
				.setPremiereDate(new GregorianCalendar(2015, 6, 22))
				.addCastMember(theRock)
				.addCastMember(robCorddry)
				.getSeries();
		
		Media interstellar = new MediaBuilder().setTitle("Interstellar")
				.setDescription("A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.")
				.setPremiereDate(new GregorianCalendar(2014, 11, 6))
				.addCastMember(matthewMcConaughey)
				.addCastMember(anneHathaway)
				.getMovie();
		
		Media gentlemen = new MediaBuilder().setTitle("The Gentlemen")
				.setDescription("An American expat tries to sell off his highly profitable marijuana empire in London, triggering plots, schemes, bribery and blackmail in an attempt to steal his domain out from under him.")
				.setPremiereDate(new GregorianCalendar(2020, 1, 30))
				.addCastMember(matthewMcConaughey)
				.addCastMember(charlieHunnam)
				.getMovie();
		
		Media friends = new MediaBuilder().setTitle("Friends")
				.setDescription("Follows the personal and professional lives of six twenty to thirty-something-year-old friends living in Manhattan.")
				.setPremiereDate(new GregorianCalendar(1994, 9, 29))
				.addCastMember(jenniferAniston)
				.addCastMember(matthewPerry)
				.addCastMember(mattLeBlanc)
				.getSeries();
		
		medias.addAll(Arrays.asList(jumanji, ballers, interstellar, gentlemen, friends));
		mediaRepo.saveAll(medias);
		
		
		ReviewRepository reviewRepo = context.getBean(ReviewRepository.class);
		Set<Review> reviews = new HashSet<>();
		Review jumanjiReview = new Review(stephenCurry, jumanji, "It wasn't bad but I don't think I'm going to watch the next episode if there will be any.", Rating.AVERAGE);
		Review ballersReviewOne = new Review(csabaSandor, ballers, "I enjoyed a lot. I'm really disappointed that after the 5th season it was cancelled.", Rating.GOOD);
		Review ballersReviewTwo = new Review(stephenCurry, ballers, "This series is absolutely badass.", Rating.GOOD);
		Review interstellarReview = new Review(csabaSandor, interstellar, "Anyone who likes science and physics are going to love this movie.", Rating.GOOD);
		Review gentlemenReview = new Review(csabaSandor, gentlemen, "Just watched it in the cinema. It was awesome. I enjoyed every minute of it.", Rating.GOOD); 
		Review friendsReview = new Review(joelleHaddad, friends, "I really love this series. Best of all time. Ma favourite character is Rachel of course.", Rating.GOOD);
		reviews.addAll(Arrays.asList(jumanjiReview, ballersReviewOne, ballersReviewTwo, interstellarReview, gentlemenReview, friendsReview));
		reviewRepo.saveAll(reviews);
	}
	
}

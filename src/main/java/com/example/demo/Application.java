package com.example.demo;

import com.example.demo.hello.ChuckNoorisFact;
import com.example.demo.hello.ChuckNoorisFactsRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner seedFacts(final ChuckNoorisFactsRepository repository) {
		return args -> {
			repository.save(createFact("This is line #1"));
			repository.save(createFact("This is line #2"));
			repository.save(createFact("This is line #3"));
			repository.save(createFact("This is line #4"));
			repository.save(createFact("This is line #5"));
			repository.save(createFact("This is line #6"));
			repository.save(createFact("This is line #7"));
			repository.save(createFact("This is line #8"));
			repository.save(createFact("This is line #9"));
			repository.save(createFact("This is line #10"));
			repository.save(createFact("This is line #11"));
			repository.save(createFact("This is line #12"));

			for (final ChuckNoorisFact fact : repository.findAll()) {
				LOGGER.info("Loaded : " + fact.getFact());
			}
		};
	}

	public ChuckNoorisFact createFact(String fact) {
		ChuckNoorisFact noorisFact = new ChuckNoorisFact();
		noorisFact.setFact(fact);
		return noorisFact;
	}
}

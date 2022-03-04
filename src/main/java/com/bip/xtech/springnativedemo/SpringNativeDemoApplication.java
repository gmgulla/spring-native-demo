package com.bip.xtech.springnativedemo;

import com.bip.xtech.springnativedemo.domain.Team;
import com.bip.xtech.springnativedemo.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class SpringNativeDemoApplication implements CommandLineRunner {

	@Autowired
	private TeamRepository teamRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringNativeDemoApplication.class, args);
		log.info("Hello world!");

	}

	@Override
	public void run(String... args) throws Exception {
		teamRepository.saveAll(
				List.of(
						new Team("Napoli", "Napoli", 57),
						new Team("Milan", "Milano", 57),
						new Team("Inter", "Milano", 55),
						new Team("Juventus", "Torino", 50),
						new Team("Atalanta", "Bergamo", 47)
				)
		);
	}
}

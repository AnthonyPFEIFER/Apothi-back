package com.apothicaires.api;

import com.apothicaires.api.model.Tatouage;
import com.apothicaires.api.service.TatouageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.EmptyResultDataAccessException;

@SpringBootApplication
public class ApothicairesApplication implements CommandLineRunner {

	@Autowired
	private TatouageService tatouageService;

	public static void main(String[] args) {
		SpringApplication.run(ApothicairesApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		try {
			System.out.println("Hello World");
			Iterable<Tatouage> tatouages = tatouageService.getTatouages();
			tatouages.forEach(tatouage -> System.out.println(tatouage.getId() + " " + tatouage.getDescription()));
		} catch (Exception e) {
			System.out.println("Ca ne démarre pas");
			throw new Exception("I am Exception Alpha!");
		}
	}
}

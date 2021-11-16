package com.apothicaires.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.EmptyResultDataAccessException;

@SpringBootApplication
public class ApothicairesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApothicairesApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		try {
			System.out.println("Hello World");
		} catch (Exception e) {
			System.out.println("Ca ne démarre pas");
			throw new Exception("I am Exception Alpha!");
		}
	}
}

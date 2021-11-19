package com.apothicaires.api;

import com.apothicaires.api.model.Photo;
import com.apothicaires.api.model.Tatouage;
import com.apothicaires.api.service.PhotoService;
import com.apothicaires.api.service.TatouageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@SpringBootApplication
public class ApothicairesApplication implements CommandLineRunner {

	@Autowired
	private TatouageService tatouageService;

	@Autowired
	private PhotoService photoService;

	public static void main(String[] args) {
		SpringApplication.run(ApothicairesApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		try {
			System.out.println("Hello World");
			Iterable<Tatouage> tatouages = tatouageService.getTatouages();
			tatouages.forEach(tatouage -> System.out.println(tatouage.getTatouage_id() + " " + tatouage.getDescription()));


			Iterable<Photo> photos = photoService.getPhotos();


			Optional<Tatouage> tatouageId = tatouageService.getTatouageById(2);
			Tatouage tatouage = tatouageId.get();
			System.out.println(tatouage);
			tatouage.getPhotos().forEach(
					photo -> System.out.println(photo.getName())
			);
/*			tatouage.getPhotos().forEach(photo -> System.out.println(photo.getName()));*/

		} catch (Exception e) {
			System.out.println("Ca ne fonctionne pas");
			throw new Exception("I am Exception Alpha!");
		}
	}
}

package com.apothicaires.api.controller;

import com.apothicaires.api.model.Tatouage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import com.apothicaires.api.model.Photo;
import com.apothicaires.api.service.PhotoService;

@RestController
@RequestMapping("/api/tatouages/photos")

public class PhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Photo> getPhotos() {
        return photoService.getPhotos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Photo> getPhotoById(@PathVariable Integer id) {
        return photoService.getPhotoById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Photo createNewPhoto(@RequestBody Photo photo) {
        return photoService.createNewPhoto(photo);
    }

    @PutMapping({"/edit/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Photo updatePhoto(@PathVariable Integer id, @RequestBody Photo photo) {
        return photoService.updatePhoto(id, photo);
    }

    @DeleteMapping({"/delete/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deletePhoto(@PathVariable Integer id) {
        photoService.deletePhoto(id);
    }

}

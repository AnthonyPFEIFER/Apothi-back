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

public class PhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping("/photos")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Photo> getPhotos() {
        return photoService.getPhotos();
    }

}

package com.apothicaires.api.service;

import java.util.Optional;

import com.apothicaires.api.model.Photo;
import com.apothicaires.api.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    public Optional<Photo> getPhotoById(final Integer id) {
        return photoRepository.findById(id);
    }

    public Iterable<Photo> getPhotos() {
        return photoRepository.findAll();
    }


    public void deletePhoto(final Integer id) {
        photoRepository.deleteById(id);
    }

    public Photo createNewPhoto(Photo photo) {
        Photo savedPhoto = photoRepository.save(photo);
        return savedPhoto;
    }

    public Photo updatePhoto(Integer id, Photo photo) {
        return photoRepository.save(photo);
    }
}

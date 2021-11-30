package com.apothicaires.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.apothicaires.api.model.Photo;
import com.apothicaires.api.model.Tatouage;
import com.apothicaires.api.repository.PhotoRepository;
import com.apothicaires.api.repository.TatouageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class TatouageService {

    @Autowired
    private TatouageRepository tatouageRepository;

    @Autowired
    private PhotoRepository photoRepository;

    public Optional<Tatouage> getTatouageById(final Integer id) {
        return tatouageRepository.findById(id);
    }

    public Iterable<Tatouage> getTatouages() {
        return tatouageRepository.findAll();
    }

    public void deleteTatouage(final Integer id) {
        tatouageRepository.deleteById(id);
    }

    public Tatouage createNewTatouage(Tatouage tatouage) {
        List<Photo> listPhoto = tatouage.getPhotos();
        tatouage.setPhotos(new ArrayList<Photo>() );
        Tatouage savedTatouage = tatouageRepository.save(tatouage);
        if( listPhoto != null ){
            for (Photo photo : listPhoto) {
                photo.setTatouage_id(savedTatouage.getTatouage_id());
                photoRepository.save(photo);
                savedTatouage.addPhoto(photo);
            }
        }
        return savedTatouage;
    }

    public Tatouage updateTatouage(Integer id, Tatouage tatouage) {
        return tatouageRepository.save(tatouage);
    }
}

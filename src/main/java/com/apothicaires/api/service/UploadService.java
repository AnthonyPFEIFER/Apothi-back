package com.apothicaires.api.service;

import com.apothicaires.api.model.Photo;
import com.apothicaires.api.model.Tatouage;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class UploadService {

    private TatouageService tatouageService;
    private PhotoService photoService;

    public Tatouage multipleCreate(Photo photo, Tatouage tatouage){
        Tatouage generatedTatouage = this.tatouageService.createNewTatouage(tatouage);
//        Integer idGenerated = generatedTatouage.getTatouage_id();
//        Photo photoWithId = photo;
        photo.setTatouage(tatouage);
        this.photoService.createNewPhoto(photo);
        return generatedTatouage;
    }
}

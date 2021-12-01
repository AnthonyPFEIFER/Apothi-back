package com.apothicaires.api.service;

import java.util.Optional;

import com.apothicaires.api.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class UploadService {
    @Autowired
    private PhotoRepository photoRepository;


}

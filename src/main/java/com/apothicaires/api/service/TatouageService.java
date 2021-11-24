package com.apothicaires.api.service;

import java.util.Optional;

import com.apothicaires.api.model.Tatouage;
import com.apothicaires.api.repository.TatouageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class TatouageService {

    @Autowired
    private TatouageRepository tatouageRepository;

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
        Tatouage savedTatouage = tatouageRepository.save(tatouage);
        return savedTatouage;
    }

    public Tatouage updateTatouage(Integer id, Tatouage tatouage) {
        return tatouageRepository.save(tatouage);
    }
}

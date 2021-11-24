package com.apothicaires.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import com.apothicaires.api.model.Tatouage;
import com.apothicaires.api.service.TatouageService;

@RestController
@RequestMapping("/api/tatouages")

public class TatouageController {

    @Autowired
    private TatouageService tatouageService;

    /**
     * Read - Get all tatouages
     * @return - An Iterable object of tatouages full filled
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Tatouage> getTatouages() {
        return tatouageService.getTatouages();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Tatouage> getTatouageById(@PathVariable Integer id) {
        return tatouageService.getTatouageById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Tatouage createNewTatouage(@RequestBody Tatouage tatouage) {
        return tatouageService.createNewTatouage(tatouage);
    }

    @PutMapping({"/edit/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Tatouage updateTatouage(@PathVariable Integer id, @RequestBody Tatouage tatouage) {
        return tatouageService.updateTatouage(id, tatouage);
    }

    @DeleteMapping({"/delete/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteTatouage(@PathVariable Integer id) {
        tatouageService.deleteTatouage(id);
    }
}

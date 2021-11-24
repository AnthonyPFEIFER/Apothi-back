package com.apothicaires.api.repository;

import com.apothicaires.api.model.Photo;
import com.apothicaires.api.model.Tatouage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}

package com.apothicaires.api.repository;

import com.apothicaires.api.model.Tatouage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TatouageRepository extends CrudRepository<Tatouage, Integer>  {

}

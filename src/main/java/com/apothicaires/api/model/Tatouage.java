package com.apothicaires.api.model;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(name = "tatouages")

public class Tatouage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tatouage_id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            mappedBy = "tatouage_id"
    )
 //   @JoinColumn(name = "tatouage_id")
    List<Photo> photos = new ArrayList<>();


    public void addPhoto(Photo photo){
        photos.add(photo);
    }




}

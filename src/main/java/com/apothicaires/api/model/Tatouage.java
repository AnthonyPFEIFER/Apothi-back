package com.apothicaires.api.model;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
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
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "tatouage_id")
    List<Photo> photos = new ArrayList<>();





    public Integer getTatouage_id() {
        return tatouage_id;
    }

    public void setTatouage_id(Integer tatouage_id) {
        this.tatouage_id = tatouage_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }


}

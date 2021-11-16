package com.apothicaires.api.model;

import javax.persistence.*;


import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tatouages")

public class Tatouage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="photos")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tatouage")
    private List<Photo> photos;

}

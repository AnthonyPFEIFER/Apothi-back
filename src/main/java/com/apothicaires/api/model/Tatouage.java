package com.apothicaires.api.model;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
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

    @OneToMany
/*            (
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )*/
    private Set<Photo> photos;

//    @JoinColumn(name = "tatouage_id")
//    List<Photo> photos = new ArrayList<>();

}

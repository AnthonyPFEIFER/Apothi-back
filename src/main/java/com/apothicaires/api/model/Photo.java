package com.apothicaires.api.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Data
@Entity
@Table(name = "photos")
@Getter
@Setter
public class Photo implements Serializable {

    @Id
    @Column(name = "photo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer photo_id;
    private String type;
    private String name;

//    private Integer tatouage_id;
/*    @ManyToOne
    @JoinColumn(name="tatouage_id", nullable = false)*/
    private Integer tatouage_id;
//    private Tatouage tatouage;


    private String path;

}
package com.apothicaires.api.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "photos")
public class Photo implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String name;

    @Column(name = "picByte", length = 1000)
    @JsonIgnore
    private byte[] picByte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tatouage_id")
    private Tatouage tatouage;

}

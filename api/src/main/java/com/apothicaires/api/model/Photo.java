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
    @Column(name = "photo_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer photo_id;
    private String type;
    private String name;
    private Integer tatouage_id;

    public Integer getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(Integer photo_id) {
        this.photo_id = photo_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTatouage_id() {
        return tatouage_id;
    }

    public void setTatouage_id(Integer tatouage_id) {
        this.tatouage_id = tatouage_id;
    }

    /*    @Column(name = "picByte", length = 1000)
    @JsonIgnore
    private byte[] picByte;*/


}
package com.bridgelabz.techstackservice.model;

import com.bridgelabz.techstackservice.DTO.TechStackDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "techStack")
@Data
public class TechStackModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime creatorStamp;
    private String creatorUser;
    private String imagePath;
    private boolean status;
    private String techName;

    public TechStackModel(TechStackDTO techStackDTO) {
        this.creatorStamp = techStackDTO.getCreatorStamp();
        this.creatorUser = techStackDTO.getCreatorUser();
        this.imagePath = techStackDTO.getImagePath();
        this.status = techStackDTO.isStatus();
        this.techName = techStackDTO.getTechName();
    }

    public TechStackModel() {

    }
}

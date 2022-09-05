package com.bridgelabz.techstackservice.DTO;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TechStackDTO {
    private LocalDateTime creatorStamp;
    private String creatorUser;
    private String imagePath;
    private boolean status;
    private String techName;
}

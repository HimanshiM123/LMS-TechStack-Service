package com.bridgelabz.techstackservice.service;

import com.bridgelabz.techstackservice.DTO.TechStackDTO;
import com.bridgelabz.techstackservice.util.Response;
import org.springframework.stereotype.Service;

@Service
public interface ITechStackService {
    Response addTechStackDetails(TechStackDTO techStackDTO, String token);

    Response getAllTechStackDetails(String token);

    Response updateTechStackDetails(long id, TechStackDTO techStackDTO, String token);

    Response deleteTechStackDetails(Long id, String token);
}

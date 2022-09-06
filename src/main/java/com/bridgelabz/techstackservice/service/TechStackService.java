package com.bridgelabz.techstackservice.service;

import com.bridgelabz.techstackservice.DTO.TechStackDTO;
import com.bridgelabz.techstackservice.exception.LMSException;
import com.bridgelabz.techstackservice.model.TechStackModel;
import com.bridgelabz.techstackservice.repository.ITechStackRepository;
import com.bridgelabz.techstackservice.util.Response;
import com.bridgelabz.techstackservice.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TechStackService implements ITechStackService{
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    ITechStackRepository techStackRepository;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public Response addTechStackDetails(TechStackDTO techStackDTO, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8082/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            TechStackModel techStackModel = new TechStackModel(techStackDTO);
            techStackModel.setCreatorStamp(LocalDateTime.now());
            techStackRepository.save(techStackModel);
            return new Response("Successfully added", 200, techStackModel);
        }
       throw new LMSException(400, "Not Found");
    }

    @Override
    public Response getAllTechStackDetails(String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8082/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Long techStackId = tokenUtil.decodeToken(token);
            Optional<TechStackModel> isTechPresent = techStackRepository.findById(techStackId);
            if (isTechPresent.isPresent()) {
                List<TechStackModel> isTechStackPresent = techStackRepository.findAll();
                if (isTechStackPresent.size() > 0) {
                    return new Response("Successfully added", 200, isTechStackPresent);
                } else {
                    throw new LMSException(400, "No TechStacks Found");
                }
              }
            }
            throw new LMSException(400, "Token is Wrong");
    }

    @Override
    public Response updateTechStackDetails(long id, TechStackDTO techStackDTO, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8082/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Long techStackId = tokenUtil.decodeToken(token);
            Optional<TechStackModel> isTechStack = techStackRepository.findById(techStackId);
            if (isTechStack.isPresent()) {
                isTechStack.get().setTechName(techStackDTO.getTechName());
                isTechStack.get().setImagePath(techStackDTO.getImagePath());
                isTechStack.get().setStatus(techStackDTO.isStatus());
                isTechStack.get().setCreatorStamp(LocalDateTime.now());
                techStackRepository.save(isTechStack.get());
                return new Response("Successfully Updated", 200, isTechStack.get());
            } else {
                throw new LMSException(400, "Not techStack found with this id");
            }
        }
        throw new LMSException(400, "Invalid Token");
    }

    @Override
    public Response deleteTechStackDetails(Long id, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8082/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Long techStackId = tokenUtil.decodeToken(token);
            Optional<TechStackModel> isTechStack = techStackRepository.findById(techStackId);
            if (isTechStack.isPresent()) {
                techStackRepository.delete(isTechStack.get());
                return new Response("Deleted Successfully", 200, isTechStack);
            } else {
                throw new LMSException(400, "Not found techStack with this id");
            }

        }
        throw new LMSException(400, "Token Wrong");
    }
}

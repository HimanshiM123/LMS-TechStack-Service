package com.bridgelabz.techstackservice.controller;

import com.bridgelabz.techstackservice.DTO.TechStackDTO;
import com.bridgelabz.techstackservice.service.ITechStackService;
import com.bridgelabz.techstackservice.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
   /*
     Purpose : TechStackController to process Data API's
     version : 1.0
     @author : Himanshi Mohabe
    */
@RestController
@RequestMapping("/techStack")
public class TechStackController {
    @Autowired
    ITechStackService techStackService;

       /*
        *@Purpose:to add techStack details into the TechStack Repository
        * @Param : TechStackDTO, token
        */

    @PostMapping(value = "/addTechStackDetails")
    ResponseEntity<Response> addTechStackDetails(@Valid @RequestBody TechStackDTO techStackDTO, @RequestHeader String token) {

        Response response = techStackService.addTechStackDetails(techStackDTO, token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

           /*
            *@Purpose : to get list of TechStack details in the techStack Repository using token
             @Param  : token
           */
    @GetMapping("/getTechStack")
    ResponseEntity<Response> getAllTechStackDetails(@RequestHeader String token){

        Response response = techStackService.getAllTechStackDetails(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

          /*
           @Purpose : Able to update TechStack details into the TeckStack Repository
           @Param : techStackDTO, id and token
           */

    @PutMapping("updateTechStackDetails/{id}")
    ResponseEntity<Response> updateTechStackDetails(@Valid @RequestBody TechStackDTO techStackDTO, @PathVariable long id, @RequestHeader String token){
        Response response = techStackService.updateTechStackDetails(id, techStackDTO, token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

           /*
            @Purpose : Able to delete TechStack details by id in the TechStack Repository
            @Param : token and id
           */

    @DeleteMapping("deleteBankDetails/{id}")
    ResponseEntity<Response> deleteTechStackDetails(@PathVariable Long id, @RequestHeader String token){

        Response response = techStackService.deleteTechStackDetails(id, token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

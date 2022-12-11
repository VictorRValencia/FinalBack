package com.company.ProyectoFinalBack.controller;
import com.company.ProyectoFinalBack.exceptions.BadRequestException;
import com.company.ProyectoFinalBack.exceptions.ResourceNotFoundException;
import com.company.ProyectoFinalBack.model.Dentist;
import com.company.ProyectoFinalBack.model.DentistDTO;
import com.company.ProyectoFinalBack.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    @Autowired
    private DentistService dentistService;

    @GetMapping
    public ResponseEntity<List<Dentist>> searchAll(){
        return ResponseEntity.ok(dentistService.searchAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentist> searchById(@PathVariable Integer id) throws BadRequestException, ResourceNotFoundException {
        Dentist dentist = dentistService.searchDentist(id).orElse(null);
        return ResponseEntity.ok(dentist);
    }

    @PostMapping()
    public ResponseEntity<?> registerDentist(@RequestBody DentistDTO dentistDTO) throws BadRequestException {
        dentistService.registerDentist(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Dentist> updateDentist (@RequestBody Dentist dentist) throws BadRequestException, ResourceNotFoundException {
        return ResponseEntity.ok(dentistService.updateDentist(dentist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) throws ResourceNotFoundException, BadRequestException {
        dentistService.deleteDentist(id);
        return ResponseEntity.ok("Removed dentist with ID " + id);
    }

}

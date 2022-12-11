package com.company.ProyectoFinalBack.controller;


import com.company.ProyectoFinalBack.exceptions.BadRequestException;
import com.company.ProyectoFinalBack.exceptions.ResourceNotFoundException;
import com.company.ProyectoFinalBack.model.Turn;
import com.company.ProyectoFinalBack.service.DentistService;
import com.company.ProyectoFinalBack.service.PatientService;
import com.company.ProyectoFinalBack.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turn")
public class TurnController {

    @Autowired
    private TurnService turnService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DentistService dentistService;

    @GetMapping()
    public ResponseEntity<List<Turn>> searchTurnAll(){
        return ResponseEntity.ok(turnService.ListTurn());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turn> searchTurnById(@PathVariable Integer id) throws BadRequestException {
        Turn turn = turnService.searchTurn(id).orElse(null);
        return ResponseEntity.ok(turn);
    }

    @PostMapping()
    public ResponseEntity<Turn> registerTurn(@RequestBody Turn turn) throws BadRequestException{
        ResponseEntity<Turn> response;
        if (patientService.searchPatient(turn.getPatient().getId()).isPresent() && dentistService.searchDentist(turn.getDentist().getId()).isPresent())
            response = ResponseEntity.ok(turnService.registerTurn(turn));
        else
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return response;
     }

    @PutMapping()
    public ResponseEntity<Turn> updateTurn(@RequestBody Turn turn) throws BadRequestException{
        ResponseEntity<Turn> response;
        if (patientService.searchPatient(turn.getPatient().getId()).isPresent() && dentistService.searchDentist(turn.getDentist().getId()).isPresent())
            response = ResponseEntity.ok(turnService.registerTurn(turn));
        else
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTurn(@PathVariable Integer id) throws BadRequestException, ResourceNotFoundException {
        turnService.deleteTurn(id);
        return ResponseEntity.ok("Removed shift with ID " + id);
    }




}

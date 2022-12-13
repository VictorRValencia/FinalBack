package com.company.ProyectoFinalBack.controller;

import com.company.ProyectoFinalBack.exceptions.BadRequestException;
import com.company.ProyectoFinalBack.exceptions.ResourceNotFoundException;
import com.company.ProyectoFinalBack.model.Patient;
import com.company.ProyectoFinalBack.service.PatientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping()
    public ResponseEntity<List<Patient>> searchPatientAll() {
        return ResponseEntity.ok(patientService.searchAllPatient());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> searchByIDPatient(@PathVariable Integer id) throws BadRequestException {
        Patient patient = patientService.searchPatient(id).orElse(null);
        return ResponseEntity.ok(patient);
    }

    @PostMapping()
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient){
        return ResponseEntity.ok(patientService.savePatient(patient));
    }


    @PutMapping()
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) throws BadRequestException, ResourceNotFoundException {
        return ResponseEntity.ok(patientService.updatePatient(patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatientByID (@PathVariable Integer id) throws BadRequestException, ResourceNotFoundException {
        patientService.deletePatient(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/search/{dni}")
    public ResponseEntity<Patient> searchPatientByDni(@PathVariable String dni){
        Patient patient = patientService.searchPatientByDni(dni);
        if (patient != null){
            return ResponseEntity.ok(patient);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

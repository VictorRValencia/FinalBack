package com.company.ProyectoFinalBack.service;

import com.company.ProyectoFinalBack.exceptions.BadRequestException;
import com.company.ProyectoFinalBack.exceptions.ResourceNotFoundException;
import com.company.ProyectoFinalBack.model.Patient;
import com.company.ProyectoFinalBack.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Optional<Patient> searchPatient(Integer id) throws BadRequestException {
        if (!patientRepository.existsById(id))
            throw new BadRequestException("The patient with ID does not exist " + id);
        return patientRepository.findById(id);
    }

    public List<Patient> searchAllPatient(){
        return patientRepository.findAll();
    }

    public void deletePatient(Integer id) throws ResourceNotFoundException, BadRequestException {
        if (searchPatient(id).isEmpty())
            throw new ResourceNotFoundException("The patient with ID does not exist " + id);
        patientRepository.deleteById(id);
    }

    public Patient updatePatient(Patient patient) throws ResourceNotFoundException, BadRequestException {
        if (searchPatient(patient.getId()).isEmpty())
            throw new ResourceNotFoundException("The patient with ID does not exist " + patient.getId());
        return patientRepository.save(patient);
    }

    public Patient searchPatientByDni(String dni){
        return patientRepository.searchPatientByDni(dni);
    }

}

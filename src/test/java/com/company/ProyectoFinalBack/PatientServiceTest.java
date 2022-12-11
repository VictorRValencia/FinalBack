package com.company.ProyectoFinalBack;

import com.company.ProyectoFinalBack.exceptions.BadRequestException;
import com.company.ProyectoFinalBack.model.Address;
import com.company.ProyectoFinalBack.model.Patient;
import com.company.ProyectoFinalBack.service.PatientService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;



    @Test
    public void addAndSeachPatientTest() throws BadRequestException {

        Address address = new Address("Calle", "msada", "fdifos");
        Patient patient = patientService.savePatient(new Patient("victor","valencia","1005707481",new Date(), address));

        Assert.assertNotNull(patientService.searchPatient(patient.getId()));
    }
}

package com.company.ProyectoFinalBack;

import com.company.ProyectoFinalBack.exceptions.BadRequestException;
import com.company.ProyectoFinalBack.model.Dentist;
import com.company.ProyectoFinalBack.service.DentistService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class DentistServiceTest {

    @Autowired
    private DentistService dentistService;

    public void loadDataSet() throws BadRequestException {
        this.dentistService.registerDentist(new Dentist("Victor","Valencia",1005707481));
    }

    @Test
    public void addDentist() throws BadRequestException {
        this.loadDataSet();
        Dentist dentist = dentistService.registerDentist(new Dentist("Juan", "Ramirez", 31548154));
        Assert.assertTrue(dentist.getId() != null);
    }
}

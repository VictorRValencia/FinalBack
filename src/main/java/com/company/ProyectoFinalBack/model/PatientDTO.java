package com.company.ProyectoFinalBack.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class PatientDTO {

    private Integer id;
    private String FirstName;
    private String lastName;
    private String dni;
    private Date dateOfAdmission;

    private Address address;

    private Set<Turn> turns = new HashSet<>();

}

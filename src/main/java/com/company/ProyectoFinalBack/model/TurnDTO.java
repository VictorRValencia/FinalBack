package com.company.ProyectoFinalBack.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter @Setter
public class TurnDTO {

    private Integer id;
    private Patient patient;
    private Dentist dentist;
    private Date date;
}

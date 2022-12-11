package com.company.ProyectoFinalBack.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Integer tuition;

    @JsonIgnore
    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    private Set<Turn> turns = new HashSet<>();

    public Dentist() {
    }

    public Dentist(String firstName, String lastName, Integer tuition) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tuition = tuition;
    }

    public Dentist(Integer id, String firstName, String lastName, Integer tuition) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tuition = tuition;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getTuition() {
        return tuition;
    }

    public void setTuition(Integer tuition) {
        this.tuition = tuition;
    }

    public Set<Turn> getTurns() {
        return turns;
    }

    public void setTurns(Set<Turn> turns) {
        this.turns = turns;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tuition=" + tuition +
                '}';
    }
}

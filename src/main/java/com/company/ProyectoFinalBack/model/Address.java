package com.company.ProyectoFinalBack.model;

import javax.persistence.*;


@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String street;

    @Column
    private String location;

    @Column
    private String province;

    public Address() {
    }

    public Address(String street, String location, String province) {
        this.street = street;
        this.location = location;
        this.province = province;
    }

    public Address(Long id, String street, String location, String province) {
        this.id = id;
        this.street = street;
        this.location = location;
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", location='" + location + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}

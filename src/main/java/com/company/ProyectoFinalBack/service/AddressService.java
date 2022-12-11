package com.company.ProyectoFinalBack.service;

import com.company.ProyectoFinalBack.model.Address;
import com.company.ProyectoFinalBack.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address saveAddress(Address address){
        addressRepository.save(address);
        return address;
    }

    public Optional<Address> sarchAddress(Integer id){
        return Optional.of(addressRepository.getOne(Long.valueOf(id)));
    }

    public List<Address> searchAddressAll(){
        return addressRepository.findAll();
    }

    public void deleteAddress(Integer id){
        addressRepository.deleteById(Long.valueOf(id));
    }

}

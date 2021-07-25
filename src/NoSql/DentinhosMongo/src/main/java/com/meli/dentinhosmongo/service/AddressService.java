package com.meli.dentinhosmongo.service;

import com.meli.dentinhosmongo.entity.Address;
import com.meli.dentinhosmongo.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address checkAddress(Address transientAddress) {
        Address persistedAddress = this.addressRepository.findAddressByStreetAndDistrict(transientAddress.getStreet(), transientAddress.getDistrict());

        if (persistedAddress != null)
            return persistedAddress;

        return this.addressRepository.save(transientAddress);
    }
}

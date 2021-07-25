package com.meli.dentinhosmongo.repository;

import com.meli.dentinhosmongo.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {

    Address findAddressByStreetAndDistrict(String street, String district);
}

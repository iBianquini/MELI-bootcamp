package com.meli.dentinhosmongo.repository;

import com.meli.dentinhosmongo.entity.Dentist;
import com.meli.dentinhosmongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<Dentist> findByCodeMpIn(List<String> dentistsMp);

    User findByDni(String patientDni);

    Dentist findByCodeMp(String codeMp);
}
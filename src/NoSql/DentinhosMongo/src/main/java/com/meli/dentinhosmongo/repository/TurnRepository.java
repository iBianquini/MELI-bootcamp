package com.meli.dentinhosmongo.repository;

import com.meli.dentinhosmongo.entity.Dentist;
import com.meli.dentinhosmongo.entity.Turn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnRepository extends MongoRepository<Turn, String> {

    List<Turn> findTurnByDentistsContains(Dentist dentist);
}

package com.meli.dentinhosmongo.repository;

import com.meli.dentinhosmongo.entity.Turn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepository extends MongoRepository<Turn, String> {
}

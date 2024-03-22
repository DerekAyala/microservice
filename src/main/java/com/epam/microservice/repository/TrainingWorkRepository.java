package com.epam.microservice.repository;

import com.epam.microservice.entity.TrainingWork;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingWorkRepository extends MongoRepository<TrainingWork, Long> {
    Optional<TrainingWork> findByUsername(String username);
}

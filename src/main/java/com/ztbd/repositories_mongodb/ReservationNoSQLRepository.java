package com.ztbd.repositories_mongodb;

import com.ztbd.models.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationNoSQLRepository extends MongoRepository<Reservation, String> {
}
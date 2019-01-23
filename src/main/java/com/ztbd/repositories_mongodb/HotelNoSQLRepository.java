package com.ztbd.repositories_mongodb;
import com.ztbd.models.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelNoSQLRepository extends MongoRepository<Hotel, Long> {
}
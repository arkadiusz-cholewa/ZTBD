package com.ztbd.repositories_mongodb;

import com.ztbd.models.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomNoSQLRepository extends MongoRepository<Room, Long> {
    List<Room> findByHotelId(Long hotelId);
}
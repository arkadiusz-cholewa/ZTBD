package com.ztbd.controllers;

import com.ztbd.models.Room;
import com.ztbd.repositories.HotelRepository;
import com.ztbd.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/hotels/{hotelId}/rooms")
    public List<Room> getAllRoomsByHotelId(@PathVariable (value = "hotelId") Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }

    @PostMapping("/hotels/{hotelId}/rooms")
    public Room createRoom(@PathVariable (value = "hotelId") Long hotelId,
                                 @Valid @RequestBody Room room) {
        return hotelRepository.findById(hotelId).map(hotel -> {
            room.setHotel(hotel);
            return roomRepository.save(room);
        }).orElseThrow(() -> new ResourceNotFoundException("Hotel", "hotelId", hotelId));
    }

    @PutMapping("/hotels/{hotelId}/rooms/{roomId}")
    public Room updateRoom(@PathVariable (value = "hotelId") Long hotelId,
                                 @PathVariable (value = "roomId") Long roomId,
                                 @Valid @RequestBody Room roomRequest) {
        if(!hotelRepository.existsById(hotelId)) {
            throw new ResourceNotFoundException("Hotel", "hotelId", hotelId);
        }

        return roomRepository.findById(roomId).map(room -> {
            room.setNumber(roomRequest.getNumber());
            room.setAmountOfPeople(roomRequest.getAmountOfPeople());
            room.setState(roomRequest.getState());
            room.setPricePerDay(roomRequest.getPricePerDay());
            return roomRepository.save(room);
        }).orElseThrow(() -> new ResourceNotFoundException("Room", "roomId", roomId));
    }

    @DeleteMapping("/hotels/{hotelId}/rooms/{roomId}")
    public ResponseEntity<?> deleteRoom(@PathVariable (value = "hotelId") Long hotelId,
                                           @PathVariable (value = "roomId") Long roomId) {
        if(!hotelRepository.existsById(hotelId)) {
            throw new ResourceNotFoundException("Hotel", "hotelId", hotelId);
        }

        return roomRepository.findById(roomId).map(room -> {
            roomRepository.delete(room);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Room", "roomId", roomId));
    }
}

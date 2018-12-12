package com.ztbd.controllers;

import com.ztbd.models.Room;
import com.ztbd.repositories.RoomRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable("id") Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room", "id", id));;
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> list = roomRepository.findAll();
        return new ResponseEntity<List<Room>>(list, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Void> addRoom(@RequestBody Room room) {
        roomRepository.saveAndFlush(room);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room) {
        roomRepository.save(room);
        return new ResponseEntity<Room>(room, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable("id") Long id) {
        roomRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

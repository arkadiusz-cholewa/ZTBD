package com.ztbd.controllers;

import com.ztbd.models.Hotel;
import com.ztbd.models.Room;

import com.ztbd.repositories_mongodb.HotelNoSQLRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelNoSQLRepository hotelRepository;

    public HotelController(HotelNoSQLRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable("id") String id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", id));;
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

        @GetMapping("")
        public Page<Hotel> getAllHotels(Pageable pageable) {
            return hotelRepository.findAll(pageable);
        }

    @PostMapping("")
    public Hotel createHotel(@Valid @RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @PutMapping("/{hotelId}")
    public Hotel updateHotel(@PathVariable String hotelId, @Valid @RequestBody Hotel hotelRequest) {
        return hotelRepository.findById(hotelId).map(hotel -> {
            hotel.setCity(hotelRequest.getCity());
            hotel.setName(hotelRequest.getName());
            hotel.setPostalCode(hotelRequest.getPostalCode());
            hotel.setPhoneNumber(hotelRequest.getPhoneNumber());
            hotel.setStreetAndNumber(hotelRequest.getStreetAndNumber());
            return hotelRepository.save(hotel);
        }).orElseThrow(() -> new ResourceNotFoundException("Hotel", "hotelId", hotelId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable("id") String id) {
        hotelRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

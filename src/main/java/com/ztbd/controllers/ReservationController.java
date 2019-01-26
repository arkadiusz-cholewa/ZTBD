package com.ztbd.controllers;

import com.ztbd.models.Hotel;
import com.ztbd.models.Reservation;
import com.ztbd.models.Room;
import com.ztbd.models.User;
import com.ztbd.repositories.HotelRepository;
import com.ztbd.repositories.ReservationRepository;
import com.ztbd.repositories.RoomRepository;
import com.ztbd.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/protected/reservations")
public class ReservationController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelRepository hotelRepository;

    private ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable("id") Long id) {
        Reservation room = reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room", "id", id));
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> list = reservationRepository.findAll();
        return new ResponseEntity<List<Reservation>>(list, HttpStatus.OK);
    }

    @PostMapping("/hotels/{hotelId}/rooms/{roomId}/users/{userId}")
    public Reservation createReservation(
            @PathVariable (value = "hotelId") Long hotelId,
            @PathVariable (value = "roomId") Long roomId,
            @PathVariable (value = "userId") Long userId,
                            @RequestBody Reservation reservation) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel", "hotelId", hotelId));
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room", "roomId", roomId));

        reservation.setUser(user);
        reservation.setHotel(hotel);
       reservation.setRoom(room);

        reservationRepository.save(reservation);
        return reservation;
    }

    @PutMapping("/{id}")
    public Reservation updateReservation( @PathVariable (value = "id") Long id, @RequestBody Reservation reservation) {
        return reservationRepository.findById(id).map(r -> {
            r.setDateFrom(reservation.getDateFrom());
            r.setDateTo(reservation.getDateTo());
            return reservationRepository.save(r);
        }).orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", id));
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") Long id) {
        reservationRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.pwojtowicz.pam.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/getall")
    public List<Reservation> getReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/byid/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping("/by_roomid/{id}")
    public List<Reservation> getReservationsByRoom(@PathVariable Long roomId){
        return reservationService.getReservationsByRoomId(roomId);
    }

    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        reservation.setDateCreated(LocalDate.now());
        reservation.setDateUpdated(LocalDate.now());
        return reservationService.addReservation(reservation);
    }

    @PutMapping("/update/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        return reservationService.updateReservation(id, reservation);
    }

    @DeleteMapping("/del/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
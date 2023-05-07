package com.pwojtowicz.pam.Reservation;

import com.pwojtowicz.pam.Room.Room;
import com.pwojtowicz.pam.Room.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }


    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found -> id: " + id));
    }

    public List<Reservation> getReservationsByRoomId(Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new EntityNotFoundException("Room not found -> id: " + roomId));
        return reservationRepository.findByRoom(room);
    }

    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation reservation) {
        Reservation reservationToUpdate = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found -> id: " + id));

        reservationToUpdate.setCheckIn(reservation.getCheckIn());
        reservationToUpdate.setCheckOut(reservation.getCheckOut());
        reservationToUpdate.setUser(reservation.getUser());
        reservationToUpdate.setRoom(reservation.getRoom());

        return reservationRepository.save(reservationToUpdate);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
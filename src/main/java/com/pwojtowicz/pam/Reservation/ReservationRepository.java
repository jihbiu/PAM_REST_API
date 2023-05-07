package com.pwojtowicz.pam.Reservation;

import com.pwojtowicz.pam.Room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    //@Query("SELECT r FROM Reservation r")
    //List<Reservation> findAllSimple();

    List<Reservation> findByRoom(Room room);
    List<Reservation> findByUser_Id(Long id);
}

package com.pwojtowicz.pam.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r.id, r.price, r.currency, r.size, r.description, r.hotel, r.perks, r.images " +
            "FROM Room r WHERE r.id = :id")
    List<Room> findRoomsSimple();
}

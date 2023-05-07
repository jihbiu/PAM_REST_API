package com.pwojtowicz.pam.Room;

import com.pwojtowicz.pam.Hotel.Hotel;
import com.pwojtowicz.pam.Hotel.HotelRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
@DependsOn("perkConfig")
public class RoomConfig {

    private RoomRepository roomRepository;
    private HotelRepository hotelRepository;

    @Autowired
    public RoomConfig(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }


    @PostConstruct
    public void initializeRooms() {
        List<Room> rooms = List.of(
            new Room(100.0, "PLN", 30),
            new Room(200.0, "PLN", 40),
            new Room(300.0, "PLN", 50),
            new Room(400.0, "PLN", 60),
            new Room(500.0, "PLN", 70)
        );
        List<Hotel> hotels = hotelRepository.findAll();

        Random random = new Random();

        //Assign random hotel to rooms
        List<Room> roomsCopy = new ArrayList<>(rooms);
        for (Hotel hotel : hotels) {
            int randomId = random.nextInt(roomsCopy.size());
            Room room = roomsCopy.get(randomId);
            room.setHotel(hotel);
            roomRepository.save(room);
            roomsCopy.remove(randomId);
        }
    }
}
package com.pwojtowicz.pam.Room;

import com.pwojtowicz.pam.User.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms(){
        return roomRepository.findAll();
    }

    public List<Room> getRoomsSimple(){
        return roomRepository.findRoomsSimple();
    }


    public Room getRoomById(Long id){
        return roomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found -> id: " + id));
    }
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Room not found -> id: " + id));
        roomRepository.delete(room);
    }
}

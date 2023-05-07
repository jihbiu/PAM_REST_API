package com.pwojtowicz.pam.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/room")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/getall")
    public List<Room> getRooms() {
        return roomService.getRooms();
    }

    @GetMapping("/getall/simple")
    public List<Room> getRoomsSimple() {
        return roomService.getRoomsSimple();
    }

    @GetMapping("/byid/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @PostMapping("/add/")
    public Room addRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }
}

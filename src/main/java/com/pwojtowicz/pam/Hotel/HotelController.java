package com.pwojtowicz.pam.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/getall")
    public List<Hotel> getHotels(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/byid/{id}")
    public Hotel getHotelById(@PathVariable Long id){
        return hotelService.getHotelById(id);
    }

    @GetMapping("/hotel_and_rooms/{id}")
    public Hotel getHotelAndRooms(@PathVariable Long id){
        return hotelService.getHotelAndRoomsById(id);
    }

    @PostMapping("/add/")
    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
    }

    @PutMapping("/update/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        return hotelService.updateHotel(id, hotel);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHotel(@PathVariable Long id){
        hotelService.deleteHotel(id);
    }



}

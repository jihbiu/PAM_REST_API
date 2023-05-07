package com.pwojtowicz.pam.Hotel;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    public final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id){
        return hotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found -> id: " + id));
    }

    public Hotel getHotelAndRoomsById(Long id){
        return hotelRepository.findByIdWithRooms(id);
    }

    public Hotel addHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Long id, Hotel hotel) {
        Hotel existingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found with id: " + id));

        existingHotel.setStreet(hotel.getStreet());
        existingHotel.setCity(hotel.getCity());
        existingHotel.setRooms(hotel.getRooms());

        return hotelRepository.save(existingHotel);
    }


    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}

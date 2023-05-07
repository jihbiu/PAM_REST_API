package com.pwojtowicz.pam.Hotel;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

@Configuration
@DependsOn("userConfig")
public class HotelConfig {

    private HotelRepository hotelRepository;

    @Autowired
    public HotelConfig(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @PostConstruct
    public void initializeHotels() {
        Hotel hotel1 = new Hotel(
                "Paris",
                "Croissant 16a"
        );
        Hotel hotel2 = new Hotel(
                "Hamburg",
                "Burger 2"
        );
        Hotel hotel3 = new Hotel(
                "London",
                "England 31"
        );

        hotelRepository.save(hotel1);
        hotelRepository.save(hotel2);
        hotelRepository.save(hotel3);
    }
}
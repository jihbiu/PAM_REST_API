package com.pwojtowicz.pam.Reservation;

import com.pwojtowicz.pam.Room.Room;
import com.pwojtowicz.pam.Room.RoomRepository;
import com.pwojtowicz.pam.User.User;
import com.pwojtowicz.pam.User.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Configuration
@DependsOn("reviewConfig")
public class ReservationConfig {
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationConfig(UserRepository userRepository, RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    @PostConstruct
    public void initializeReservations() {
        List<Room> rooms = roomRepository.findAll();
        List<User> users = userRepository.findAll();
        Random random = new Random();
        LocalDate now = LocalDate.now();

        for (int i = 0; i < 7; i++) {
            Room room = rooms.get(random.nextInt(rooms.size()));
            User user = users.get(random.nextInt(users.size()));
            LocalDate checkIn = now.plusDays(random.nextInt(6));
            LocalDate checkOut = checkIn.plusDays(random.nextInt(5) + 1);

            Reservation reservation = new Reservation(
                    user,
                    now,
                    now,
                    checkIn,
                    checkOut,
                    room
            );
            reservationRepository.save(reservation);
        }
    }
}

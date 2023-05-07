package com.pwojtowicz.pam.User;

import com.pwojtowicz.pam.Reservation.Reservation;
import com.pwojtowicz.pam.Reservation.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Component
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public UserService(UserRepository userRepository, ReservationRepository reservationRepository) {
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found -> id: " + id));
    }

    public List<Reservation> getUserReservations(Long id) {
        //return reservationRepository.findByUser_Id(id);
       User user = userRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
       return user.getReservations();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found -> id: " + id));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setReservations(user.getReservations());

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found -> id: " + id));
        userRepository.deleteById(id);
    }
}

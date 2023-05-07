package com.pwojtowicz.pam.Review;

import com.pwojtowicz.pam.Room.Room;
import com.pwojtowicz.pam.Room.RoomRepository;
import com.pwojtowicz.pam.User.User;
import com.pwojtowicz.pam.User.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.Random;

@Configuration
@DependsOn({"userConfig", "roomConfig"})
public class ReviewConfig {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;


    @Autowired
    public ReviewConfig(ReviewRepository reviewRepository, UserRepository userRepository, RoomRepository roomRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    @PostConstruct
    public void initializeReviews() {
        List<User> users = userRepository.findAll();
        List<Room> rooms = roomRepository.findAll();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            User user = users.get(random.nextInt(users.size()));
            Room room = rooms.get(random.nextInt(rooms.size()));
            int reviewValue = random.nextInt(5);
            String text = "Rand review | room -> " + room.getId();
            Review review = new Review();
            review.setUser(user);
            review.setRoom(room);
            review.setValue(reviewValue);
            review.setText(text);
            reviewRepository.save(review);
        }
    }
}

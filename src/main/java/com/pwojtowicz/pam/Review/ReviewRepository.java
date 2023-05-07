package com.pwojtowicz.pam.Review;

import com.pwojtowicz.pam.Room.Room;
import com.pwojtowicz.pam.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByRoom(Room room);
    List<Review> findByUser(User user);
}

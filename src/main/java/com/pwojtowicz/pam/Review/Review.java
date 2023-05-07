package com.pwojtowicz.pam.Review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pwojtowicz.pam.Room.Room;
import com.pwojtowicz.pam.User.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="text")
    private String text;

    @Column(name="value")
    private Integer value;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="room_id", nullable=false)
    @JsonIgnore
    private Room room;


    public Review(String text, Integer value, User user, Room room) {
        this.text = text;
        this.value = value;
        this.user = user;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", value=" + value +
                ", user_id=" + user.getId() +
                ", room_id=" + room.getId() +
                '}';
    }
}

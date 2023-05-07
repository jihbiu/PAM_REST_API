package com.pwojtowicz.pam.Reservation;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pwojtowicz.pam.Room.Room;
import com.pwojtowicz.pam.User.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="uniqueCode")
    private String uniqueCode = "";

    @Column(name="dateCreated")
    private LocalDate dateCreated;

    @Column(name="dateUpdated")
    private LocalDate dateUpdated;

    @Column(name="checkIn")
    private LocalDate checkIn;

    @Column(name="checkOut")
    private LocalDate checkOut;

    @JsonIgnoreProperties("reservations")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @JsonIgnoreProperties("reservations")
    @ManyToOne
    @JoinColumn(name="room_id", nullable=false)
    private Room room;

    public Reservation(User user, LocalDate dateCreated, LocalDate dateUpdated, LocalDate checkIn, LocalDate checkOut, Room room) {
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.user = user;
        this.room = room;

        this.uniqueCode = generateUniqueCode(user.getFirstName(), dateCreated.getDayOfMonth(), room.getId());
    }

    private static String generateUniqueCode(String firstName, int dayOfMonth, Long roomId) {
        StringBuilder uniqueCode = new StringBuilder(String.valueOf(dayOfMonth));
        Random random = new Random();

        for(int i = 0; i < firstName.length(); i++) {
            int asciiNameValue = firstName.charAt(i);
            asciiNameValue += random.nextInt(0, 9);

            uniqueCode.append(asciiNameValue);
        }
        uniqueCode.append(roomId);

        return uniqueCode.toString();
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user=" + user +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", room=" + room +
                '}';
    }
}

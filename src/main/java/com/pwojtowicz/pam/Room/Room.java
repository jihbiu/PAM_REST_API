package com.pwojtowicz.pam.Room;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pwojtowicz.pam.Hotel.Hotel;
import com.pwojtowicz.pam.Perk.Perk;
import com.pwojtowicz.pam.Review.Review;
import com.pwojtowicz.pam.oImage.oImage;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="price")
    private double price;

    @Column(name="currency")
    private String currency;

    @Column(name="size")
    private Integer size;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="hotel_id")
    @JsonIgnoreProperties("rooms")
    private Hotel hotel;

    @ManyToMany
    private List<Perk> perks;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("rooms")
    private Set<Review> reviewSet;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("rooms")
    private List<oImage> images;

    public Room(double price, String currency, Integer size, String description, Hotel hotel, List<Perk> perks, Set<Review> reviewSet, List<oImage> images) {
        this.price = price;
        this.currency = currency;
        this.size = size;
        this.description = description;
        this.hotel = hotel;
        this.perks = perks;
        this.reviewSet = reviewSet;
        this.images = images;
    }

    public Room(double price, String currency, Integer size, Hotel hotel) {
        this.price = price;
        this.currency = currency;
        this.size = size;
        this.hotel = hotel;
    }

    public Room(double price, String currency, Integer size) {
        this.price = price;
        this.currency = currency;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", size=" + size +
                ", description='" + description + '\'' +
                '}';
    }
}

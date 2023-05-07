package com.pwojtowicz.pam.Perk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pwojtowicz.pam.Room.Room;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="perk")
public class Perk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "perks")
    private List<Room> rooms;

    public Perk(String name) {
        this.name = name;
    }

    public Perk(String name, List<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }
}

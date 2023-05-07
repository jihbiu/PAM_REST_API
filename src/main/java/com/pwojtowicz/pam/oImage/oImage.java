package com.pwojtowicz.pam.oImage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pwojtowicz.pam.Room.Room;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="oImage")
public class oImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name="data", nullable = false)
    private byte[] data;

    @Column(name = "mime_type", nullable = false)
    private String mimeType;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}

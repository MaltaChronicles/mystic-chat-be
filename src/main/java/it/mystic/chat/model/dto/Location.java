package it.mystic.chat.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long locationId;

    @Column
    String name;

    @Column
    String description;

    @Column
    String imageUrl;

    @Column
    String backgroundUrl;

    @Column
    String ambientUrl;

    @OneToMany(mappedBy = "id.location", cascade = CascadeType.ALL)
    List<LocationEvent> events;

    @OneToMany(mappedBy = "id.location", cascade = CascadeType.ALL)
    List<LocationMessage> chat;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "manager")
    Player manager;
}

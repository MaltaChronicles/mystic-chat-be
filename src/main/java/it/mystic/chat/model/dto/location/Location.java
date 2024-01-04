package it.mystic.chat.model.dto.location;

import it.mystic.chat.model.dto.player.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    Long locationId;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String description;

    @Column(nullable = false)
    String imageUrl;

    @Column(nullable = false)
    String backgroundUrl;

    @Column
    String ambientUrl;

    @OneToMany(mappedBy = "id.location", cascade = CascadeType.ALL)
    @ToStringExclude
    List<LocationEvent> events;

    @OneToMany(mappedBy = "id.location", cascade = CascadeType.ALL)
    @ToStringExclude
    List<LocationMessage> chat;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager")
    @ToStringExclude
    Player manager;

    @OneToMany(mappedBy = "id.location", cascade = CascadeType.ALL)
    @ToStringExclude
    List<LocationPoster> locationPosters;
}

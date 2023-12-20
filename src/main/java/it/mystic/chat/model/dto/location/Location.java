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
    @ToStringExclude
    List<LocationEvent> events;

    @OneToMany(mappedBy = "id.location", cascade = CascadeType.ALL)
    @ToStringExclude
    List<LocationMessage> chat;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "manager")
    @ToStringExclude
    Player manager;

    @OneToMany(mappedBy = "id.location", cascade = CascadeType.ALL)
    @ToStringExclude
    List<LocationPoster> locationPosters;
}

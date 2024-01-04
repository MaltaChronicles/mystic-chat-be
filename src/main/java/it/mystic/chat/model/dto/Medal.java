package it.mystic.chat.model.dto;

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
public class Medal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    Long medalId;

    @Column(nullable = false, updatable = false)
    String name;

    @Column(nullable = false)
    String imageUrl;

    @ManyToMany(mappedBy = "medals")
    @ToStringExclude
    List<Player> players;
}

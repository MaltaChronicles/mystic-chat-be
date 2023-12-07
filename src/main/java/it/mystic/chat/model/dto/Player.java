package it.mystic.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long playerId;
    @Column
    String username;
    @Column
    String password;
    @Column
    String email;
    @Column
    Date dataIscrizione;
    @Column
    Date ultimaAzione;
    @Column
    Date ultimoAccesso;
    @Column
    Date ultimaGiocata;

    @OneToMany(mappedBy = "id.player", cascade = CascadeType.ALL)
    List<PlayerRole> roles;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "character1")
    Character character1;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "character2")
    Character character2;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "character3")
    Character character3;

    @ManyToOne
    @JoinColumn(name = "activeCharacter")
    Character activeCharacter;

    @ManyToOne
    @JoinColumn(name = "location")
    Location location;

    @ManyToMany
    @JoinTable(
            name = "player_medal",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "medal_id")
    )
    List<Medal> medals;
}

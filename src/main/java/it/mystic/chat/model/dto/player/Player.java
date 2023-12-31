package it.mystic.chat.model.dto.player;

import it.mystic.chat.model.dto.Medal;
import it.mystic.chat.model.dto.character.Character;
import it.mystic.chat.model.dto.chat.ChatMessage;
import it.mystic.chat.model.dto.location.Location;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

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
    @Column(updatable = false)
    Long playerId;
    @Column(unique = true, nullable = false, updatable = false)
    String username;
    @Column(nullable = false)
    String password;
    @Column(unique = true, nullable = false)
    String email;
    @Column
    String message;
    @Column(nullable = false)
    Date dataIscrizione;
    @Column
    Date ultimaAzione;
    @Column
    Date ultimoAccesso;
    @Column
    Date ultimaGiocata;

    @OneToMany(mappedBy = "id.player", cascade = CascadeType.ALL)
    @ToStringExclude
    List<PlayerRole> roles;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character1")
    @ToStringExclude
    Character character1;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character2")
    @ToStringExclude
    Character character2;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character3")
    @ToStringExclude
    Character character3;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activeCharacter")
    @ToStringExclude
    Character activeCharacter;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location")
    @ToStringExclude
    Location location;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "player_medal",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "medal_id")
    )
    @ToStringExclude
    List<Medal> medals;

    @OneToMany(mappedBy = "id.player", cascade = CascadeType.ALL)
    @ToStringExclude
    List<PlayerChat> chats;
    @OneToMany(mappedBy = "id.player", cascade = CascadeType.ALL)
    @ToStringExclude
    List<ChatMessage> chatMessages;
}

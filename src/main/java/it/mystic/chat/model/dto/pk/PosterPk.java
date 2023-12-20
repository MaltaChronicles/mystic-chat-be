package it.mystic.chat.model.dto.pk;

import it.mystic.chat.model.dto.character.Character;
import it.mystic.chat.model.dto.location.Location;
import it.mystic.chat.model.dto.player.Player;
import it.mystic.chat.model.enums.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PosterPk implements Serializable {
    @Column
    String uuid;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "author")
    Character character;

    @ManyToOne
    @JoinColumn(name = "location_id")
    Location location;
}

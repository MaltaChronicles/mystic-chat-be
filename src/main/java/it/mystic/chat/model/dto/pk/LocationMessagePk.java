package it.mystic.chat.model.dto.pk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.dto.Location;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LocationMessagePk implements Serializable {
    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonIgnore
    Location location;

    @ManyToOne
    @JoinColumn(name = "character_id")
    @JsonIgnore
    Character character;

    Date data;
}

package it.mystic.chat.model.dto.pk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.dto.Location;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationMessagePk implements Serializable {
    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonIgnore
    Location location;

    String sender;

    Date data;
}

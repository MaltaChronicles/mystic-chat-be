package it.mystic.chat.model.dto.location;

import it.mystic.chat.model.dto.pk.LocationPosterPk;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class LocationPoster {
    @EmbeddedId
    LocationPosterPk id;

    @Column(nullable = false, updatable = false)
    String title;
    @Column(length = 65000, nullable = false, updatable = false)
    String body;
    @Column(nullable = false, updatable = false)
    Date date;
    @Column(nullable = false)
    Boolean isPin;
}

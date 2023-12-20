package it.mystic.chat.model.dto.location;

import it.mystic.chat.model.dto.pk.PosterPk;
import jakarta.persistence.*;
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
    PosterPk id;

    @Column
    String title;
    @Column(length = 65000)
    String body;
    @Column
    Date date;
}

package it.mystic.chat.model.dto.pk;

import it.mystic.chat.model.dto.location.Location;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    Location location;

    @Column(updatable = false)
    String sender;

    @Column(updatable = false)
    Date date;
}

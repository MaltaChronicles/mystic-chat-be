package it.mystic.chat.model.dto.location;

import it.mystic.chat.model.dto.pk.LocationMessagePk;
import it.mystic.chat.model.enums.MessageType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class LocationMessage {
    @EmbeddedId
    LocationMessagePk id;

    @Column(nullable = false, updatable = false)
    MessageType messageType;

    @Column(nullable = false, updatable = false)
    String tag;

    @Column(length = 65000, nullable = false, updatable = false)
    String body;

    @Column(updatable = false)
    String imageLink;
}

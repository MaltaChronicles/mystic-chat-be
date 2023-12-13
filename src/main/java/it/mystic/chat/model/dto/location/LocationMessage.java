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

    @Column
    MessageType messageType;

    @Column
    String tag;

    @Column(length = 65000)
    String body;

    @Column
    String imageLink;
}

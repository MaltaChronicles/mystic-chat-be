package it.mystic.chat.model.dto;

import it.mystic.chat.model.dto.pk.LocationEventPk;
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
public class LocationEvent {
    @EmbeddedId
    LocationEventPk id;

    @Column
    String name;

    @Column
    String description;

    @Column
    String createBy;
}

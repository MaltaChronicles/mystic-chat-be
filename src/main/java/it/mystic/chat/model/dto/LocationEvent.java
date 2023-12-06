package it.mystic.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.mystic.chat.model.dto.pk.LocationEventPk;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

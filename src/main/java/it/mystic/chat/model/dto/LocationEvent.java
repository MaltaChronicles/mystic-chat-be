package it.mystic.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Column
    String name;

    @Column
    String description;

    @Column
    Date date;

    @Column
    String playerName;

    @OneToOne
    @JoinColumn(name = "location_id")
    @JsonIgnore
    @Id
    Location location;
}

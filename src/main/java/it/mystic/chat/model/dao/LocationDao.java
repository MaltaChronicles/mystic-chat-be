package it.mystic.chat.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.mystic.chat.model.dto.LocationEvent;
import it.mystic.chat.model.dto.LocationMessage;
import it.mystic.chat.model.dto.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDao {

    String name;

    String description;
}

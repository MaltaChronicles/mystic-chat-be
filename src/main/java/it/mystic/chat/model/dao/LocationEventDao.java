package it.mystic.chat.model.dao;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationEventDao {

    String name;

    String description;

    String createBy;
}

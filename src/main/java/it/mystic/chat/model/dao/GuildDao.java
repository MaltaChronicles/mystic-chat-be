package it.mystic.chat.model.dao;

import it.mystic.chat.model.dto.GuildList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuildDao {
    String name;
    String description;
}

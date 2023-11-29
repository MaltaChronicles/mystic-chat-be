package it.mystic.chat.model.dao;

import it.mystic.chat.model.enums.Job;
import it.mystic.chat.model.enums.Origin;
import it.mystic.chat.model.enums.Race;
import it.mystic.chat.model.enums.Theme;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CharacterDao {
    String name;
    String identity;
    Origin origin;
    Theme theme;
    Job job;
    Race race;
}

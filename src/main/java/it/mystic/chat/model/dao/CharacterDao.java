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

    @NotNull @Pattern(regexp = "^[A-Za-z]+$", message = "Il nome può contenere solamente caratteri alfabetici")
    String name;
    @NotNull @Pattern(regexp = "^[A-Za-z]+$", message = "L'identità può contenere solamente caratteri alfabetici")
    String identity;
    @NotNull
    Origin origin;
    @NotNull
    Theme theme;
    @NotNull
    Job job;
    @NotNull
    Race race;
}

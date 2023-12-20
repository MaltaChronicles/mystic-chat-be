package it.mystic.chat.model.dao.character;

import it.mystic.chat.model.enums.Job;
import it.mystic.chat.model.enums.Origin;
import it.mystic.chat.model.enums.Race;
import it.mystic.chat.model.enums.Theme;

public record CharacterDao(
        String name,
        String identity,
        Origin origin,
        Theme theme,
        Job job,
        Race race
) {
}

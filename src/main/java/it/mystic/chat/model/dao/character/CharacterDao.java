package it.mystic.chat.model.dao.character;

import it.mystic.chat.model.enums.*;

public record CharacterDao(
        String name,
        String identity,
        Origin origin,
        Theme theme,
        Job job,
        Race race,
        Divinity divinity
) {
}

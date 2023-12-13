package it.mystic.chat.model.response.character;

import it.mystic.chat.model.enums.*;

public record CharacterResponse(
        Long characterId,
        String name,
        String identity,
        Origin origin,
        Theme theme,
        StandardOfLiving standardOfLiving,
        Job job,
        Race race,
        String masterNote,
        String rumors,
        CharacterDescriptionResponse description
) {
}

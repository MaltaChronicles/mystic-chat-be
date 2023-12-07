package it.mystic.chat.model.response;

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
        Color rightEye,
        Color leftEye,
        Color hair,
        Double height,
        Double weight,
        Integer age,
        Gender gender,
        String imageUrl
) {
}

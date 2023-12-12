package it.mystic.chat.model.response;

import it.mystic.chat.model.enums.Color;
import it.mystic.chat.model.enums.Gender;

public record CharacterDescriptionResponse(
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

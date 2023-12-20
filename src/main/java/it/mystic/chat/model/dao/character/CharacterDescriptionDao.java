package it.mystic.chat.model.dao.character;

import it.mystic.chat.model.enums.Color;
import it.mystic.chat.model.enums.Gender;


public record CharacterDescriptionDao(

        Color rightEye,
        Color leftEye,
        Color hair,
        Double height,
        Double weight,
        Integer age,
        Gender gender
) {
}

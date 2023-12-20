package it.mystic.chat.model.dao.text;

import it.mystic.chat.model.enums.TextType;

public record TextDao(

        TextType type,
        String title,
        String body
) {
}

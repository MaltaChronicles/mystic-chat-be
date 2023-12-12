package it.mystic.chat.model.dao;

import it.mystic.chat.model.enums.TextType;
import jakarta.persistence.Column;

public record TextDao(

        TextType type,
        String title,
        String body
) {
}

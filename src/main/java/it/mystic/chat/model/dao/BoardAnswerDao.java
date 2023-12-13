package it.mystic.chat.model.dao;

import java.util.Date;
import java.util.UUID;

public record BoardAnswerDao(
        Long playerId,
        String body
) {
}

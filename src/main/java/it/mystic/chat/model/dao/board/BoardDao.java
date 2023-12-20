package it.mystic.chat.model.dao.board;

import it.mystic.chat.model.enums.BoardType;

public record BoardDao(
        BoardType type,
        String title,
        String body
) {
}

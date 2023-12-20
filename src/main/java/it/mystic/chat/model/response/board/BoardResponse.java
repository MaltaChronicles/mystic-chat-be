package it.mystic.chat.model.response.board;


public record BoardResponse(
        Long boardId,
        String title,
        String body
) {
}

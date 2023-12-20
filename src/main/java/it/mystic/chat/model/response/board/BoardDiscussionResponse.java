package it.mystic.chat.model.response.board;

import java.util.Date;


public record BoardDiscussionResponse(
        Long boardId,
        Long openPlayerId,
        String discussionUuid,
        String title,
        String body,
        Boolean isOpen,
        Boolean isPin,
        Date openDate
) {
}

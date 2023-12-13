package it.mystic.chat.model.response.id;

import java.util.Date;
import java.util.UUID;

public record BoardDiscussionIdResponse(
        Long boardId,
        Long openPlayerId,
        String discussionUuid

){
}

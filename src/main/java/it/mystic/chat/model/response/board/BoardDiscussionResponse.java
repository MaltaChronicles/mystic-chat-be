package it.mystic.chat.model.response.board;

import it.mystic.chat.model.response.id.BoardDiscussionIdResponse;

import java.util.Date;


public record BoardDiscussionResponse (
        BoardDiscussionIdResponse id,
        String title,

        String body,

        Boolean isOpen,
        Boolean isPin,

        Date openDate
){}

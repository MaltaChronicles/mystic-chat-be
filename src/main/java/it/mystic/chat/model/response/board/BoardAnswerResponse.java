package it.mystic.chat.model.response.board;


import java.util.Date;


public record BoardAnswerResponse(
        Long writtenPlayerId,
        String answerUuid,
        String body,
        Date answerDate
) {
}

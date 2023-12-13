package it.mystic.chat.model.response.board;


import java.util.Date;
import java.util.List;


public record BoardAnswerResponse(
    Long writtenPlayerId,
    String answerUuid,
    String body,
    Date answerDate
){}

package it.mystic.chat.model.response.id;

import java.util.Date;
import java.util.UUID;

public record BoardAnswerIdResponse(
        Long writtenPlayerId,
        String answerUuid

){
}

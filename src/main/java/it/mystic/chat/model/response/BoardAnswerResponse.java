package it.mystic.chat.model.response;

import it.mystic.chat.model.dto.pk.BoardAnswerPk;
import it.mystic.chat.model.response.id.BoardAnswerIdResponse;

import java.util.Date;
import java.util.List;


public record BoardAnswerResponse(
    BoardAnswerIdResponse id,
    String body,
    Date answerDate
){}

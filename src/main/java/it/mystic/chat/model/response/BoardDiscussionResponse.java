package it.mystic.chat.model.response;

import it.mystic.chat.model.dto.BoardAnswer;
import it.mystic.chat.model.dto.pk.BoardDiscussionPk;
import it.mystic.chat.model.response.id.BoardAnswerIdResponse;
import it.mystic.chat.model.response.id.BoardDiscussionIdResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.Date;
import java.util.List;


public record BoardDiscussionResponse (
        BoardDiscussionIdResponse id,
        String title,

        String body,

        Boolean isOpen,
        Boolean isPin,

        Date openDate
){}

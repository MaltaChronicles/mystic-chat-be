package it.mystic.chat.model.response;

import it.mystic.chat.model.dto.BoardDiscussion;
import it.mystic.chat.model.enums.BoardType;
import it.mystic.chat.model.response.id.BoardDiscussionIdResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.List;


public record BoardResponse (
    Long boardId,
    String title,
    String body
){}

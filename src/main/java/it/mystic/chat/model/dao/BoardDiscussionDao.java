package it.mystic.chat.model.dao;

import it.mystic.chat.model.dto.BoardAnswer;
import it.mystic.chat.model.dto.BoardDiscussion;
import it.mystic.chat.model.dto.pk.BoardDiscussionPk;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.List;

public record BoardDiscussionDao (
    String title,
    String body
) {}

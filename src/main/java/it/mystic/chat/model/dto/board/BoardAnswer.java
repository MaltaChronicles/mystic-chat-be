package it.mystic.chat.model.dto.board;

import it.mystic.chat.model.dto.pk.BoardAnswerPk;
import it.mystic.chat.model.dto.pk.BoardDiscussionPk;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class BoardAnswer {
    @EmbeddedId
    BoardAnswerPk id;

    @Column(length = 65000)
    String body;

    @Column
    Date answerDate;
}

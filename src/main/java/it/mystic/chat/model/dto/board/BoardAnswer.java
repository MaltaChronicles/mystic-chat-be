package it.mystic.chat.model.dto.board;

import it.mystic.chat.model.dto.pk.BoardAnswerPk;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

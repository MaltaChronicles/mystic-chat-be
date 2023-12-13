package it.mystic.chat.model.dto.pk;

import it.mystic.chat.model.dto.Board;
import it.mystic.chat.model.dto.BoardDiscussion;
import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.dto.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardAnswerPk implements Serializable {
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "board_id", referencedColumnName = "board_id", insertable = false, updatable = false),
        @JoinColumn(name = "openBy", referencedColumnName = "openBy", insertable = false, updatable = false),
        @JoinColumn(name = "discussionUuid", referencedColumnName = "discussionUuid", insertable = false, updatable = false)
    })
    BoardDiscussion discussion;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "writtenBy")
    Player writtenBy;

    @Column
    String answerUuid;


}

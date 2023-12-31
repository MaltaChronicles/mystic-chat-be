package it.mystic.chat.model.dto.pk;

import it.mystic.chat.model.dto.board.BoardDiscussion;
import it.mystic.chat.model.dto.player.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardAnswerPk implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "board_id", referencedColumnName = "board_id", insertable = false, updatable = false),
            @JoinColumn(name = "openBy", referencedColumnName = "openBy", insertable = false, updatable = false),
            @JoinColumn(name = "discussionUuid", referencedColumnName = "discussionUuid", insertable = false, updatable = false)
    })
    BoardDiscussion discussion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "writtenBy")
    Player writtenBy;

    @Column(updatable = false)
    String answerUuid;


}

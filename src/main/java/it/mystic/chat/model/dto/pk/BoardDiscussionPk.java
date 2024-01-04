package it.mystic.chat.model.dto.pk;

import it.mystic.chat.model.dto.board.Board;
import it.mystic.chat.model.dto.player.Player;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDiscussionPk implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id")
    Board board;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "openBy")
    Player openBy;

    @Column(updatable = false)
    String discussionUuid;
}

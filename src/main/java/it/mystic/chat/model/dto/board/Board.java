package it.mystic.chat.model.dto.board;

import it.mystic.chat.model.enums.BoardType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long boardId;
    @Column
    BoardType type;
    @Column
    String title;
    @Column(length = 65000)
    String body;

    @OneToMany(mappedBy = "id.board", cascade = CascadeType.ALL)
    @ToStringExclude
    List<BoardDiscussion> discussions;
}

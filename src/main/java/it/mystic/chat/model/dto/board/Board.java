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
    @Column(updatable = false)
    Long boardId;
    @Column(nullable = false)
    BoardType type;
    @Column(nullable = false)
    String title;
    @Column(length = 65000, nullable = false)
    String body;

    @OneToMany(mappedBy = "id.board", cascade = CascadeType.ALL)
    @ToStringExclude
    List<BoardDiscussion> discussions;
}

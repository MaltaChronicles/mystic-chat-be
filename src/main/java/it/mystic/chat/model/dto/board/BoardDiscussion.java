package it.mystic.chat.model.dto.board;

import it.mystic.chat.model.dto.pk.BoardDiscussionPk;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class BoardDiscussion {
    @EmbeddedId
    BoardDiscussionPk id;
    @Column(unique = true, nullable = false, updatable = false)
    String title;
    @Column(nullable = false, updatable = false)
    Date openDate;
    @Column(length = 65000, nullable = false, updatable = false)
    String body;
    @Column(nullable = false)
    Boolean isOpen;
    @Column(nullable = false)
    Boolean isPin;

    @OneToMany(mappedBy = "id.discussion", cascade = CascadeType.ALL)
    @ToStringExclude
    List<BoardAnswer> answers;

}

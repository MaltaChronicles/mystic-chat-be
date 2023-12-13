package it.mystic.chat.model.dto;

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
    @Column
    String title;
    @Column
    Date openDate;
    @Column(length = 65000)
    String body;
    @Column
    Boolean isOpen;
    @Column
    Boolean isPin;

    @OneToMany(mappedBy = "id.discussion", cascade = CascadeType.ALL)
    @ToStringExclude
    List<BoardAnswer> answers;

}

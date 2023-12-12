package it.mystic.chat.model.dto;

import it.mystic.chat.model.enums.TextType;
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
public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long textId;
    @Column
    TextType type;
    @Column
    String title;
    @Column(length = 65000)
    String body;

    @OneToMany(mappedBy = "text", cascade = CascadeType.ALL)
    @ToStringExclude
    List<TextParagraph> paragraphs;
}

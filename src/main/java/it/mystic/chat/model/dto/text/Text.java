package it.mystic.chat.model.dto.text;

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
    @Column(updatable = false)
    Long textId;
    @Column(nullable = false)
    TextType type;
    @Column(nullable = false)
    String title;
    @Column(length = 65000, nullable = false)
    String body;

    @OneToMany(mappedBy = "text", cascade = CascadeType.ALL)
    @ToStringExclude
    List<TextParagraph> paragraphs;
}

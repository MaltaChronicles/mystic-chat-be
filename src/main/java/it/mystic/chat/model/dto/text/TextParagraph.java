package it.mystic.chat.model.dto.text;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class TextParagraph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    Long paragraphId;
    @Column(nullable = false)
    String title;
    @Column(length = 16000000, nullable = false)
    String body;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "text_id")
    Text text;

}

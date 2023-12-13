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
    Long paragraphId;
    @Column
    String title;
    @Column(length = 16000000)
    String body;

    @ManyToOne
    @JoinColumn(name = "text_id")
    Text text;

}

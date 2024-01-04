package it.mystic.chat.model.dto.character;

import it.mystic.chat.model.enums.Color;
import it.mystic.chat.model.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@ToString
public class CharacterDescription {
    @Column
    Color rightEye;
    @Column
    Color leftEye;
    @Column
    Color hair;
    @Column
    Double height;
    @Column
    Double weight;
    @Column
    Integer age;
    @Column
    Gender gender;
    @Column
    String imageUrl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character_id")
    @Id
    @ToStringExclude
    Character character;

    public CharacterDescription(Character character) {
        this.character = character;
    }
}

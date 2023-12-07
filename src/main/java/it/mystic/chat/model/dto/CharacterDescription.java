package it.mystic.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.mystic.chat.model.enums.Color;
import it.mystic.chat.model.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
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

    @OneToOne
    @JoinColumn(name = "character_id")
    @JsonIgnore
    @Id
    Character character;

    public CharacterDescription(Character character) {
        this.character = character;
    }
}

package it.mystic.chat.model.dto.character;

import it.mystic.chat.model.dto.pk.CharacterAbilityThreePk;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class CharacterAbilityThree {

    @EmbeddedId
    CharacterAbilityThreePk id;

    @Column(nullable = false)
    Integer level;
}

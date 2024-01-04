package it.mystic.chat.model.dto.pk;

import it.mystic.chat.model.dto.Ability;
import it.mystic.chat.model.dto.character.Character;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterAbilityThreePk implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character_id")
    Character character;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ability_id")
    Ability ability;
}

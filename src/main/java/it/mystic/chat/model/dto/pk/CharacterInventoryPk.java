package it.mystic.chat.model.dto.pk;

import it.mystic.chat.model.dto.Object;
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
public class CharacterInventoryPk implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character_id")
    Character character;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "object_id")
    Object object;
}

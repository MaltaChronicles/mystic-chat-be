package it.mystic.chat.model.dto.character;

import it.mystic.chat.model.dto.pk.CharacterInventoryPk;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class CharacterInventory {

    @EmbeddedId
    CharacterInventoryPk id;

    @Column
    Boolean isEquip;

    @Column
    Integer quantity;
}

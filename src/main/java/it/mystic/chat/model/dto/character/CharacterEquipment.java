package it.mystic.chat.model.dto.character;

import it.mystic.chat.model.dto.Object;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@ToString
public class CharacterEquipment {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rightHand")
    Object rightHand;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leftHand")
    Object leftHand;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dress")
    Object dress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accessory")
    Object accessory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet")
    Object pet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mount")
    Object mount;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character_id")
    @Id
    @ToStringExclude
    Character character;

    public CharacterEquipment(Character character) {
        this.character = character;
    }
}

package it.mystic.chat.model.dto;

import it.mystic.chat.model.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "object")
public class ObjectDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long objectId;
    @Column
    String nome;
    @Column
    String imgUrl;
    @Column
    ObjectType type;
    @Column
    String description;
    @Column
    ObjectRank rank;
    @Column
    Boolean isMartial;
    @Column
    RangeType rangeType;
    @Column
    RangeType price;

    @Column
    Feature featurePrecisionOne;
    @Column
    Feature featurePrecisionTwo;
    @Column
    Integer damage;
    @Column
    Affinity damageType;

    @Column
    Integer defenseModifier;
    @Column
    Integer resistanceModifier;
    @Column
    Integer initiativeModifier;

    @Column
    Integer lifeModifier;
    @Column
    Integer manaModifier;

    @Column
    DiceValue dexterityModifier;
    @Column
    DiceValue insightModifier;
    @Column
    DiceValue vigorModifier;
    @Column
    DiceValue willModifier;

    @Column
    Affinity physicalModifier;
    @Column
    Affinity waterModifier;
    @Column
    Affinity earthModifier;
    @Column
    Affinity fireModifier;
    @Column
    Affinity airModifier;
    @Column
    Affinity electricityModifier;
    @Column
    Affinity iceModifier;
    @Column
    Affinity lightModifier;
    @Column
    Affinity darkModifier;
    @Column
    Affinity poisonModifier;

    @Column
    Boolean isUnique;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
    private List<CharacterInventoryDto> characterInventory;
}

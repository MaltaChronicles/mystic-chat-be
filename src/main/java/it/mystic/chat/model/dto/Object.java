package it.mystic.chat.model.dto;

import it.mystic.chat.model.dto.character.CharacterInventory;
import it.mystic.chat.model.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    Long objectId;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String imageUrl;
    @Column(nullable = false)
    ObjectType type;
    @Column(nullable = false)
    String description;
    @Column(nullable = false)
    ObjectRank rank;
    @Column(nullable = false)
    Boolean isMartial;
    @Column(nullable = false)
    RangeType rangeType;
    @Column(nullable = false)
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

    @OneToMany(mappedBy = "id.object", cascade = CascadeType.ALL)
    @ToStringExclude
    List<CharacterInventory> characterInventory;
}

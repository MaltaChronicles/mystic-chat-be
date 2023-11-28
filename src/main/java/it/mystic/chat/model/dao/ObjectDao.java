package it.mystic.chat.model.dao;

import it.mystic.chat.model.enums.*;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectDao {
    Long objectId;
    String name;
    String imgUrl;
    ObjectType type;
    String description;
    ObjectRank rank;
    Boolean isMartial;
    RangeType rangeType;
    RangeType price;
    Feature featurePrecisionOne;
    Feature featurePrecisionTwo;
    Integer damage;
    Affinity damageType;
    Integer defenseModifier;
    Integer resistanceModifier;
    Integer initiativeModifier;
    Integer lifeModifier;
    Integer manaModifier;
    DiceValue dexterityModifier;
    DiceValue insightModifier;
    DiceValue vigorModifier;
    DiceValue willModifier;
    Affinity physicalModifier;
    Affinity waterModifier;
    Affinity earthModifier;
    Affinity fireModifier;
    Affinity airModifier;
    Affinity electricityModifier;
    Affinity iceModifier;
    Affinity lightModifier;
    Affinity darkModifier;
    Affinity poisonModifier;
    Boolean isUnique;
}

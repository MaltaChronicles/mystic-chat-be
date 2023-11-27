package it.mystic.chat.model.dto;

import it.mystic.chat.model.enums.Affinity;
import it.mystic.chat.model.enums.Feature;
import it.mystic.chat.model.enums.ObjectRank;
import it.mystic.chat.model.enums.ObjectType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    String description;
    @Column
    ObjectRank rank;

}

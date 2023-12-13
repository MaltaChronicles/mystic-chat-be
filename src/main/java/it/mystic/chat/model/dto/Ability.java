package it.mystic.chat.model.dto;

import it.mystic.chat.model.dto.character.CharacterAbilityThree;
import it.mystic.chat.model.enums.AbilityType;
import it.mystic.chat.model.enums.Class;
import it.mystic.chat.model.enums.DurationType;
import it.mystic.chat.model.enums.TargetType;
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
public class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long abilityId;
    @Column
    String name;
    @Column
    String imageUrl;
    @Column
    Class abilityClass;
    @Column
    AbilityType type;
    @Column
    String description;
    @Column
    DurationType duration;
    @Column
    TargetType targetType;
    @Column
    Integer maxTargetNumber;
    @Column
    Integer maxLevel;
    @Column
    Integer manaPriceForTarget;
    @Column
    Integer hpPriceForTarget;
    @Column
    String actionLink;

    @OneToMany(mappedBy = "id.ability", cascade = CascadeType.ALL)
    @ToStringExclude
    List<CharacterAbilityThree> characterAbilityThrees;
}

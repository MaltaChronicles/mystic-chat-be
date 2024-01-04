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
    @Column(updatable = false)
    Long abilityId;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String imageUrl;
    @Column(nullable = false)
    Class abilityClass;
    @Column(nullable = false)
    AbilityType type;
    @Column(nullable = false)
    String description;
    @Column(nullable = false)
    DurationType duration;
    @Column(nullable = false)
    TargetType targetType;
    @Column(nullable = false)
    Integer maxTargetNumber;
    @Column(nullable = false)
    Integer maxLevel;
    @Column(nullable = false)
    Integer manaPriceForTarget;
    @Column(nullable = false)
    Integer hpPriceForTarget;
    @Column(nullable = false)
    String actionLink;

    @OneToMany(mappedBy = "id.ability", cascade = CascadeType.ALL)
    @ToStringExclude
    List<CharacterAbilityThree> characterAbilityThrees;
}

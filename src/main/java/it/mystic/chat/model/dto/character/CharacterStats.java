package it.mystic.chat.model.dto.character;

import it.mystic.chat.model.enums.Affinity;
import it.mystic.chat.model.enums.DiceValue;
import it.mystic.chat.util.CharacterStatsUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;

import static it.mystic.chat.util.CharacterStatsUtil.obtainDiceValue;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@ToString
public class CharacterStats {
    @Column(nullable = false)
    Integer level;
    @Column(nullable = false)
    Integer totalLife;
    @Column(nullable = false)
    Integer actualLife;
    @Column(nullable = false)
    Integer crisis;
    @Column(nullable = false)
    Integer totalMana;
    @Column(nullable = false)
    Integer actualMana;
    @Column(nullable = false)
    Integer totalExperience;
    @Column(nullable = false)
    Integer actualExperience;
    @Column(nullable = false)
    Integer totalInitiative;
    @Column(nullable = false)
    Integer actualInitiative;
    @Column(nullable = false)
    Long coin;

    /* STATISTICHE */
    @Column(nullable = false)
    DiceValue totalDexterity;
    @Column(nullable = false)
    DiceValue actualDexterity;
    @Column(nullable = false)
    DiceValue totalInsight;
    @Column(nullable = false)
    DiceValue actualInsight;
    @Column(nullable = false)
    DiceValue totalVigor;
    @Column(nullable = false)
    DiceValue actualVigor;
    @Column(nullable = false)
    DiceValue totalWill;
    @Column(nullable = false)
    DiceValue actualWill;

    /* DIFESE */
    @Column(nullable = false)
    Integer totalDefense;
    @Column(nullable = false)
    Integer actualDefense;
    @Column(nullable = false)
    Integer totalResistance;
    @Column(nullable = false)
    Integer actualResistance;

    /* ABILITAZIONI */
    @Column(nullable = false)
    Boolean martialArmors;
    @Column(nullable = false)
    Boolean martialShields;
    @Column(nullable = false)
    Boolean martialMeleeWeapons;
    @Column(nullable = false)
    Boolean martialDistanceWeapons;

    /* RESISTENZE */
    @Column(nullable = false)
    Affinity physicalAffinity;
    @Column(nullable = false)
    Affinity waterAffinity;
    @Column(nullable = false)
    Affinity earthAffinity;
    @Column(nullable = false)
    Affinity fireAffinity;
    @Column(nullable = false)
    Affinity airAffinity;
    @Column(nullable = false)
    Affinity electricityAffinity;
    @Column(nullable = false)
    Affinity iceAffinity;
    @Column(nullable = false)
    Affinity lightAffinity;
    @Column(nullable = false)
    Affinity darkAffinity;
    @Column(nullable = false)
    Affinity poisonAffinity;
    @Column(nullable = false)
    Affinity actualPhysicalAffinity;
    @Column(nullable = false)
    Affinity actualWaterAffinity;
    @Column(nullable = false)
    Affinity actualEarthAffinity;
    @Column(nullable = false)
    Affinity actualFireAffinity;
    @Column(nullable = false)
    Affinity actualAirAffinity;
    @Column(nullable = false)
    Affinity actualElectricityAffinity;
    @Column(nullable = false)
    Affinity actualIceAffinity;
    @Column(nullable = false)
    Affinity actualLightAffinity;
    @Column(nullable = false)
    Affinity actualDarkAffinity;
    @Column(nullable = false)
    Affinity actualPoisonAffinity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character_id")
    @Id
    @ToStringExclude
    Character character;

    public CharacterStats(Character character) {
        this.character = character;

        level = 1;

        totalExperience = 0;
        actualExperience = 0;
        totalInitiative = 0;

        coin = 500L;

        totalDexterity = DiceValue.d6;
        totalInsight = DiceValue.d6;
        totalVigor = DiceValue.d6;
        totalWill = DiceValue.d6;

        totalDefense = obtainDiceValue(totalDexterity);
        totalResistance = obtainDiceValue(totalInsight);

        martialArmors = false;
        martialShields = false;
        martialMeleeWeapons = false;
        martialDistanceWeapons = false;

        totalLife = level + (5 * obtainDiceValue(totalVigor));
        actualLife = totalLife;
        crisis = totalLife / 2;

        totalMana = level + (5 * obtainDiceValue(totalWill));
        actualMana = totalMana;
    }
}

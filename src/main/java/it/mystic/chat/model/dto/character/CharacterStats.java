package it.mystic.chat.model.dto.character;

import it.mystic.chat.model.enums.Affinity;
import it.mystic.chat.model.enums.DiceValue;
import it.mystic.chat.model.enums.Race;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;

import static it.mystic.chat.util.CharacterStatsUtil.obtainDiceValue;
import static it.mystic.chat.util.CharacterStatsUtil.setRaceAffinity;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@ToString
public class CharacterStats {
    @Column
    Integer level;
    @Column
    Integer totalLife;
    @Column
    Integer actualLife;
    @Column
    Integer crisis;
    @Column
    Integer totalMana;
    @Column
    Integer actualMana;
    @Column
    Integer totalExperience;
    @Column
    Integer actualExperience;
    @Column
    Integer totalInitiative;
    @Column
    Integer actualInitiative;
    @Column
    Long coin;

    /* STATISTICHE */
    @Column
    DiceValue totalDexterity;
    @Column
    DiceValue actualDexterity;
    @Column
    DiceValue totalInsight;
    @Column
    DiceValue actualInsight;
    @Column
    DiceValue totalVigor;
    @Column
    DiceValue actualVigor;
    @Column
    DiceValue totalWill;
    @Column
    DiceValue actualWill;

    /* DIFESE */
    @Column
    Integer totalDefense;
    @Column
    Integer actualDefense;
    @Column
    Integer totalResistance;
    @Column
    Integer actualResistance;

    /* ABILITAZIONI */
    @Column
    Boolean martialArmors;
    @Column
    Boolean martialShields;
    @Column
    Boolean martialMeleeWeapons;
    @Column
    Boolean martialDistanceWeapons;

    /* RESISTENZE */
    @Column
    Affinity physicalAffinity;
    @Column
    Affinity waterAffinity;
    @Column
    Affinity earthAffinity;
    @Column
    Affinity fireAffinity;
    @Column
    Affinity airAffinity;
    @Column
    Affinity electricityAffinity;
    @Column
    Affinity iceAffinity;
    @Column
    Affinity lightAffinity;
    @Column
    Affinity darkAffinity;
    @Column
    Affinity poisonAffinity;
    @Column
    Affinity actualPhysicalAffinity;
    @Column
    Affinity actualWaterAffinity;
    @Column
    Affinity actualEarthAffinity;
    @Column
    Affinity actualFireAffinity;
    @Column
    Affinity actualAirAffinity;
    @Column
    Affinity actualElectricityAffinity;
    @Column
    Affinity actualIceAffinity;
    @Column
    Affinity actualLightAffinity;
    @Column
    Affinity actualDarkAffinity;
    @Column
    Affinity actualPoisonAffinity;

    @OneToOne
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

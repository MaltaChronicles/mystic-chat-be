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

        level = 0;

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

        levelUp();
        sleep();
        setRaceAffinity(character.getRace());
    }

    public void levelUp() {
        actualExperience = actualExperience - 10;
        level = level + 1;

        totalLife = level + (5 * obtainDiceValue(totalVigor));
        crisis = totalLife / 2;

        totalMana = level + (5 * obtainDiceValue(totalWill));
    }

    private Integer obtainDiceValue(DiceValue dice) {
        return Integer.valueOf(dice.toString().replace("d", ""));
    }

    public void setRaceAffinity(Race race) {
        resetAffinityToNulla();
        switch (race) {
            case Elfica -> {
                airAffinity = Affinity.Resistente;
                iceAffinity = Affinity.Debole;
            }
            case Nanica -> {
                earthAffinity = Affinity.Resistente;
                waterAffinity = Affinity.Debole;
            }
            case Orchesca -> {
                waterAffinity = Affinity.Resistente;
                fireAffinity = Affinity.Debole;
            }
            case Draconica -> {
                fireAffinity = Affinity.Resistente;
                darkAffinity = Affinity.Debole;
            }
            case Mannara -> {
                poisonAffinity = Affinity.Resistente;
                fireAffinity = Affinity.Debole;
            }
            case Fatata -> {
                lightAffinity = Affinity.Resistente;
                poisonAffinity = Affinity.Debole;
            }
            case Mezzogigante -> {
                iceAffinity = Affinity.Resistente;
                electricityAffinity = Affinity.Debole;
            }
            case Infernale -> {
                fireAffinity = Affinity.Resistente;
                iceAffinity = Affinity.Debole;
            }
            case Celestiale -> {
                lightAffinity = Affinity.Resistente;
                darkAffinity = Affinity.Debole;
            }
            case Goblinoide -> {
                earthAffinity = Affinity.Resistente;
                lightAffinity = Affinity.Debole;
            }
            case Djinn -> {
                airAffinity = Affinity.Resistente;
                waterAffinity = Affinity.Debole;
            }
            case Costrutto -> {
                iceAffinity = Affinity.Resistente;
                waterAffinity = Affinity.Debole;
            }
            case Non_Morta -> {
                darkAffinity = Affinity.Resistente;
                lightAffinity = Affinity.Debole;
            }
            case Sirenide -> {
                waterAffinity = Affinity.Resistente;
                electricityAffinity = Affinity.Debole;
            }
        }
        resetActualAffinity();
    }

    public void sleep() {
        actualLife = totalLife;
        actualMana = totalMana;

        actualInitiative = totalInitiative;

        actualDexterity = totalDexterity;
        actualInsight = totalInsight;
        actualVigor = totalVigor;
        actualWill = totalWill;

        actualDefense = totalDefense;
        actualResistance = totalResistance;

        resetActualAffinity();
    }

    private void resetActualAffinity() {
        actualPhysicalAffinity = physicalAffinity;
        actualWaterAffinity = waterAffinity;
        actualEarthAffinity = earthAffinity;
        actualFireAffinity = fireAffinity;
        actualAirAffinity = airAffinity;
        actualElectricityAffinity = electricityAffinity;
        actualIceAffinity = iceAffinity;
        actualLightAffinity = lightAffinity;
        actualDarkAffinity = darkAffinity;
        actualPoisonAffinity = poisonAffinity;
    }

    private void resetAffinityToNulla() {
        physicalAffinity = Affinity.Nulla;
        waterAffinity = Affinity.Nulla;
        earthAffinity = Affinity.Nulla;
        fireAffinity = Affinity.Nulla;
        airAffinity = Affinity.Nulla;
        electricityAffinity = Affinity.Nulla;
        iceAffinity = Affinity.Nulla;
        lightAffinity = Affinity.Nulla;
        darkAffinity = Affinity.Nulla;
        poisonAffinity = Affinity.Nulla;
    }
}

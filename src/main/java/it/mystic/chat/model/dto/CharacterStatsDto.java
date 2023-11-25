package it.mystic.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.mystic.chat.model.enums.Color;
import it.mystic.chat.model.enums.DiceValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@Table(name = "character_stats")
public class CharacterStatsDto {
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
    Boolean martialArmor;
    @Column
    Boolean martialShields;
    @Column
    Boolean martialMeleeWeapons;
    @Column
    Boolean martialDistanceWeapons;

    @OneToOne
    @JoinColumn(name = "character_id")
    @JsonIgnore
    @Id
    CharacterDto character;

    public CharacterStatsDto(){
        level = 0;

        totalExperience = 0;
        actualExperience = totalExperience;
        totalInitiative = 0;
        actualInitiative = totalInitiative;
        coin = 500L;

        totalDexterity = DiceValue.d6;
        actualDexterity = DiceValue.d6;
        totalInsight = DiceValue.d6;
        actualInsight = DiceValue.d6;
        totalVigor = DiceValue.d6;
        actualVigor = DiceValue.d6;
        totalWill = DiceValue.d6;
        actualWill = DiceValue.d6;

        totalDefense = obtainDiceValue(totalDexterity);
        actualDefense = totalDefense;

        totalResistance = obtainDiceValue(totalInsight);
        actualResistance = totalResistance;

        martialArmor = false;
        martialShields = false;
        martialMeleeWeapons = false;
        martialDistanceWeapons = false;
    }

    public void levelUp(){
        level = level + 1;

        totalLife = level + (5 * obtainDiceValue(totalVigor));
        actualLife = totalLife;
        crisis = totalLife / 2;

        totalMana = level + (5 * obtainDiceValue(totalWill));
        actualMana = totalMana;
    }

    private Integer obtainDiceValue(DiceValue dice){
        return  Integer.valueOf(dice.toString().replace("d",""));
    }
}

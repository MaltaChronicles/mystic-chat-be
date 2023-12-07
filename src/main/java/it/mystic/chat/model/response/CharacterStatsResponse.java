package it.mystic.chat.model.response;

import it.mystic.chat.model.enums.Affinity;
import it.mystic.chat.model.enums.DiceValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterStatsResponse {
    
    Integer level;
    
    Integer totalLife;
    
    Integer actualLife;
    
    Integer crisis;
    
    Integer totalMana;
    
    Integer actualMana;
    
    Integer totalExperience;
    
    Integer actualExperience;
    
    Integer totalInitiative;
    
    Integer actualInitiative;
    
    Long coin;

    /* STATISTICHE */
    
    DiceValue totalDexterity;
    
    DiceValue actualDexterity;
    
    DiceValue totalInsight;
    
    DiceValue actualInsight;
    
    DiceValue totalVigor;
    
    DiceValue actualVigor;
    
    DiceValue totalWill;
    
    DiceValue actualWill;

    /* DIFESE */
    
    Integer totalDefense;
    
    Integer actualDefense;
    
    Integer totalResistance;
    
    Integer actualResistance;

    /* ABILITAZIONI */
    
    Boolean martialArmors;
    
    Boolean martialShields;
    
    Boolean martialMeleeWeapons;
    
    Boolean martialDistanceWeapons;

    /* RESISTENZE */
    
    Affinity physicalAffinity;
    
    Affinity waterAffinity;
    
    Affinity earthAffinity;
    
    Affinity fireAffinity;
    
    Affinity airAffinity;
    
    Affinity electricityAffinity;
    
    Affinity iceAffinity;
    
    Affinity lightAffinity;
    
    Affinity darkAffinity;
    
    Affinity poisonAffinity;
    
    Affinity actualPhysicalAffinity;
    
    Affinity actualWaterAffinity;
    
    Affinity actualEarthAffinity;
    
    Affinity actualFireAffinity;
    
    Affinity actualAirAffinity;
    
    Affinity actualElectricityAffinity;
    
    Affinity actualIceAffinity;
    
    Affinity actualLightAffinity;
    
    Affinity actualDarkAffinity;
    
    Affinity actualPoisonAffinity;
}

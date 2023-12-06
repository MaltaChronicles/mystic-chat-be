package it.mystic.chat.model.dao;

import it.mystic.chat.model.enums.AbilityType;
import it.mystic.chat.model.enums.Class;
import it.mystic.chat.model.enums.DurationType;
import it.mystic.chat.model.enums.TargetType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbilityDao {
    
    String name;
    
    Class abilityClass;
    
    AbilityType type;
    
    String description;
    
    DurationType duration;
    
    TargetType targetType;
    
    Integer maxTargetNumber;
    
    Integer maxLevel;
    
    Integer manaPriceForTarget;
    
    Integer hpPriceForTarget;
}
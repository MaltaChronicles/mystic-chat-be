package it.mystic.chat.model.dao;

import it.mystic.chat.model.enums.AbilityType;
import it.mystic.chat.model.enums.Class;
import it.mystic.chat.model.enums.DurationType;
import it.mystic.chat.model.enums.TargetType;


public record AbilityDao(

        String name,

        Class abilityClass,

        AbilityType type,

        String description,

        DurationType duration,

        TargetType targetType,

        Integer maxTargetNumber,

        Integer maxLevel,

        Integer manaPriceForTarget,

        Integer hpPriceForTarget
) {
}

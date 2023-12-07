package it.mystic.chat.model.response;

import it.mystic.chat.model.enums.AbilityType;
import it.mystic.chat.model.enums.Class;
import it.mystic.chat.model.enums.DurationType;
import it.mystic.chat.model.enums.TargetType;

public record AbilityResponse(
        Long abilityId,
        String name,
        String imageUrl,
        Class abilityClass,
        AbilityType type,
        String description,
        DurationType duration,
        TargetType targetType,
        Integer maxTargetNumber,
        Integer maxLevel,
        Integer manaPriceForTarget,
        Integer hpPriceForTarget,
        String actionLink
) {
}

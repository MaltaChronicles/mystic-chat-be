package it.mystic.chat.model.response.character;

import it.mystic.chat.model.response.AbilityResponse;

public record CharacterAbilityThreeResponse(

        AbilityResponse abilityResponse,

        Integer level
) {
}

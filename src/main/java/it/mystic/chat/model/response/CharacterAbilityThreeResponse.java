package it.mystic.chat.model.response;

import it.mystic.chat.model.dto.Ability;

public record CharacterAbilityThreeResponse (

    Ability ability,

    Integer level
){}

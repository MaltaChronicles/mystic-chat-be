package it.mystic.chat.model.response;

import it.mystic.chat.model.dto.Object;

public record CharacterInventoryResponse(

        Object object,

        Boolean isEquip
) {
}

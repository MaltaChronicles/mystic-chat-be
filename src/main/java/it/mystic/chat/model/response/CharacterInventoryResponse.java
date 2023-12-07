package it.mystic.chat.model.response;

import it.mystic.chat.model.dto.Object;

public record CharacterInventoryResponse(

        ObjectResponse objectResponse,

        Boolean isEquip
) {
}

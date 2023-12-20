package it.mystic.chat.model.response.character;

import it.mystic.chat.model.response.ObjectResponse;

public record CharacterInventoryResponse(

        ObjectResponse objectResponse,

        Boolean isEquip
) {
}

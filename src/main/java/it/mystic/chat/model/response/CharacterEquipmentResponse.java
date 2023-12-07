package it.mystic.chat.model.response;

import it.mystic.chat.model.dto.Object;


public record CharacterEquipmentResponse(
        Object rightHand,
        Object leftHand,
        Object dress,
        Object accessory,
        Object pet,
        Object mount
) {
}

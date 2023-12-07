package it.mystic.chat.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.dto.Object;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterEquipmentResponse {
    Object rightHand;
    Object leftHand;
    Object dress;
    Object accessory;
    Object pet;
    Object mount;
}

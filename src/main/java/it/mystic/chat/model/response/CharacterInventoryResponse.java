package it.mystic.chat.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.mystic.chat.model.dto.Object;
import it.mystic.chat.model.dto.pk.CharacterInventoryPk;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterInventoryResponse {

    Object object;

    Boolean isEquip;
}

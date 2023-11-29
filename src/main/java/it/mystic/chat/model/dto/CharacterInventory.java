package it.mystic.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.mystic.chat.model.dto.pk.CharacterInventoryPk;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CharacterInventory {

    @EmbeddedId
    CharacterInventoryPk id;

    @Column
    Boolean isEquip;
}
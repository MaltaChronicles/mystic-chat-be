package it.mystic.chat.model.dto.pk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.mystic.chat.model.dto.CharacterDto;
import it.mystic.chat.model.dto.ObjectDto;
import it.mystic.chat.model.dto.PlayerDto;
import it.mystic.chat.model.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterInventoryPk implements Serializable {
    @ManyToOne
    @JoinColumn(name = "character_id")
    @JsonIgnore
    CharacterDto character;

    @ManyToOne
    @JoinColumn(name = "object_id")
    @JsonIgnore
    ObjectDto object;
}

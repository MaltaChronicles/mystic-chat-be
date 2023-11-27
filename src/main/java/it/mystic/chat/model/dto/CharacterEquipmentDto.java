package it.mystic.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "character_equipment")
public class CharacterEquipmentDto {

    @ManyToOne
    @JoinColumn(name = "rightHand")
    ObjectDto rightHand;

    @ManyToOne
    @JoinColumn(name = "leftHand")
    ObjectDto leftHand;

    @ManyToOne
    @JoinColumn(name = "dress")
    ObjectDto dress;

    @ManyToOne
    @JoinColumn(name = "accessory")
    ObjectDto accessory;

    @ManyToOne
    @JoinColumn(name = "pet")
    ObjectDto pet;

    @ManyToOne
    @JoinColumn(name = "mount")
    ObjectDto mount;


    @OneToOne
    @JoinColumn(name = "character_id")
    @JsonIgnore
    @Id
    CharacterDto character;

    public CharacterEquipmentDto(CharacterDto characterDto) {
        this.character = characterDto;
    }
}

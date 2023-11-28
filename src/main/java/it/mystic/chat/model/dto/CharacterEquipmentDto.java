package it.mystic.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "character_equipment")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CharacterEquipmentDto {

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "rightHand")
    ObjectDto rightHand;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "leftHand")
    ObjectDto leftHand;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "dress")
    ObjectDto dress;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "accessory")
    ObjectDto accessory;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "pet")
    ObjectDto pet;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "mount")
    ObjectDto mount;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character_id")
    @JsonIgnore
    @Id
    CharacterDto character;

    public CharacterEquipmentDto(CharacterDto characterDto) {
        this.character = characterDto;
    }
}

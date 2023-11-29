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
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CharacterEquipment {

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "rightHand")
    Object rightHand;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "leftHand")
    Object leftHand;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "dress")
    Object dress;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "accessory")
    Object accessory;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "pet")
    Object pet;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "mount")
    Object mount;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character_id")
    @JsonIgnore
    @Id
    Character character;

    public CharacterEquipment(Character character) {
        this.character = character;
    }
}

package it.mystic.chat.model.dto;

import it.mystic.chat.model.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "character_root")
public class CharacterDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long characterId;
    @Column
    String name;
    @Column
    String identity;
    @Column
    Origin origin;
    @Column
    Theme theme;
    @Column
    StandardOfLiving standardOfLiving;
    @Column
    Job job;
    @Column
    String masterNote;
    @Column
    String personalNote;
    @Column
    String rumors;

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    private CharacterStatsDto status;

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    private CharacterDescriptionDto description;

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    private CharacterEquipmentDto equipment;


    //TODO aggiungere abilità
    //TODO aggiungere legami
    //TODO Aggiungere peculiarità
}

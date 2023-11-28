package it.mystic.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.mystic.chat.model.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "character_root")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    Race race;
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

    @OneToMany(mappedBy = "character")
    private List<CharacterInventoryDto> characterInventory;


    //TODO aggiungere abilità
    //TODO aggiungere legami
    //TODO aggiungere List<LevelClass>

    public CharacterDto(String name, String identity, Origin origin, Theme theme, Job job, Race race) {
        this.name = name;
        this.identity = identity;
        this.origin = origin;
        this.theme = theme;
        this.job = job;
        this.race = race;
    }
}

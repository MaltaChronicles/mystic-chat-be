package it.mystic.chat.model.dto;

import it.mystic.chat.model.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "character_root")
public class Character {
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
    CharacterStats status;

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    CharacterDescription description;

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    CharacterEquipment equipment;

    @OneToMany(mappedBy = "id.character", cascade = CascadeType.ALL)
    List<CharacterInventory> inventory;

    @OneToMany(mappedBy = "id.character", cascade = CascadeType.ALL)
    List<CharacterAbilityThree> abilityThree;



    //TODO Aggiungere Talenti

    public Character(String name, String identity, Origin origin, Theme theme, Job job, Race race) {
        this.name = name;
        this.identity = identity;
        this.origin = origin;
        this.theme = theme;
        this.job = job;
        this.race = race;
    }

    @Override
    public String toString() {
        return "Character{" +
                "characterId=" + characterId +
                ", name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", origin=" + origin +
                ", theme=" + theme +
                ", standardOfLiving=" + standardOfLiving +
                ", job=" + job +
                ", race=" + race +
                ", masterNote='" + masterNote + '\'' +
                ", personalNote='" + personalNote + '\'' +
                ", rumors='" + rumors + '\'' +
                '}';
    }
}

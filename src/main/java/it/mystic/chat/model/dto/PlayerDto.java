package it.mystic.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "player")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PlayerDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long playerId;
    @Column
    String username;
    @Column
    String password;
    @Column
    String email;
    @Column
    Date dataIscrizione;
    @Column
    Date ultimaAzione;

    @OneToMany(mappedBy = "id.player", cascade = CascadeType.ALL)
    private List<PlayerRoleDto> roles;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "character1")
    CharacterDto character1;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "character2")
    CharacterDto character2;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "character3")
    CharacterDto character3;
}

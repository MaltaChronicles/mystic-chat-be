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
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Player {

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
    private List<PlayerRole> roles;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "character1")
    Character character1;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "character2")
    Character character2;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "character3")
    Character character3;
}

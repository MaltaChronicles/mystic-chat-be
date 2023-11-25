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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//TODO fix this
@Table(name = "player")
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

    public PlayerDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dataIscrizione = new Date();
    }
}

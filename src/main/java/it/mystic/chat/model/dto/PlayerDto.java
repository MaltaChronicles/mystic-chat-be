package it.mystic.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//TODO fix this
@Table(name = "player")
public class PlayerDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
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
    //TODO aggiungere ruoli [ADMIN, GUIDA, MASTER]

    public PlayerDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dataIscrizione = new Date();
        this.ultimaAzione = null;
    }
}

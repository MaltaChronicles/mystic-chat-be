package it.mystic.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Medal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long medalId;

    @Column
    String name;

    @Column
    String imageUrl;

    @ManyToMany(mappedBy = "medals")
    List<Player> players;
}

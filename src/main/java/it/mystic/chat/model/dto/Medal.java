package it.mystic.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Medal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long medalId;

    @Column
    String name;

    @Column
    String imageUrl;

    @ManyToMany(mappedBy = "medals")
    @ToStringExclude
    List<Player> players;
}

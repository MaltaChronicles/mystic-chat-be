package it.mystic.chat.model.response;

import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.dto.Location;
import it.mystic.chat.model.dto.Medal;
import it.mystic.chat.model.dto.PlayerRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


public record PlayerResponse (

    Long playerId,
    String username,
    Date dataIscrizione,
    Date ultimaAzione,
    Date ultimoAccesso,
    Date ultimaGiocata,

    List<PlayerRoleResponse> roles,

    EssentialData character1,
    EssentialData character2,
    EssentialData character3,
    EssentialData activeCharacter,

    EssentialData location,

    List<MedalResponse> medals
) {}

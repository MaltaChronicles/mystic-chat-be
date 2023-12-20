package it.mystic.chat.model.response.player;

import it.mystic.chat.model.response.EssentialData;
import it.mystic.chat.model.response.MedalResponse;

import java.util.Date;
import java.util.List;


public record PlayerResponse(

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
) {
}

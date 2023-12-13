package it.mystic.chat.model.response.player;

import it.mystic.chat.model.enums.Role;


public record PlayerRoleResponse (
        Role role,
        Boolean isBoss
){}

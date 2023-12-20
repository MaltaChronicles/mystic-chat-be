package it.mystic.chat.model.response.chat;

public record ChatMemberResponse(
        Long playerId,
        String username,
        Boolean isAdmin
) {
}

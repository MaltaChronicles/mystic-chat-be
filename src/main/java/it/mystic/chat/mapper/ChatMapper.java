package it.mystic.chat.mapper;

import it.mystic.chat.model.dto.chat.Chat;
import it.mystic.chat.model.dto.chat.ChatMessage;
import it.mystic.chat.model.dto.pk.ChatMessagePk;
import it.mystic.chat.model.dto.pk.PlayerChatPk;
import it.mystic.chat.model.dto.player.Player;
import it.mystic.chat.model.dto.player.PlayerChat;
import it.mystic.chat.model.response.EssentialData;
import it.mystic.chat.model.response.chat.ChatMemberResponse;
import it.mystic.chat.model.response.chat.ChatMessageResponse;
import it.mystic.chat.model.response.chat.ChatResponse;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class ChatMapper {
    public Chat daoToDto(String title) {
        if (Objects.isNull(title))
            return null;
        return new Chat(
                UUID.randomUUID().toString(),
                title,
                null,
                null
        );
    }

    public ChatResponse dtoToResponse(Chat chat) {
        if (Objects.isNull(chat))
            return null;
        return new ChatResponse(
                chat.getChatId(),
                chat.getTitle()
        );
    }

    public List<ChatMemberResponse> playerChatListToResponseList(List<PlayerChat> playerChats) {
        if (Objects.isNull(playerChats))
            return null;
        return playerChats.stream().map(playerChat -> {
            return new ChatMemberResponse(
                    playerChat.getId().getPlayer().getPlayerId(),
                    playerChat.getId().getPlayer().getUsername(),
                    playerChat.getIsAdmin());
        }).toList();
    }

    public List<ChatMessageResponse> messageListDtoToResponse(String chatId, List<ChatMessage> chatMessageList) {
        if (Objects.isNull(chatMessageList))
            return null;
        return chatMessageList.stream()
                .filter(chatMessage -> {
                    return Objects.equals(chatMessage.getId().getChat().getChatId(), chatId);
                }).map(this::messageDtoToResponse).toList();
    }

    public PlayerChat playerChatDaoToDto(PlayerChatPk playerChatPk) {
        if (Objects.isNull(playerChatPk))
            return null;
        return new PlayerChat(
                playerChatPk,
                false
        );
    }

    public ChatMessage messageToDto(Chat chat, Player player, String body) {
        if (Objects.isNull(chat) || Objects.isNull(player) || Objects.isNull(body))
            return null;
        return new ChatMessage(
                new ChatMessagePk(
                        player,
                        chat,
                        new Date()
                ),
                body
        );
    }

    public ChatMessageResponse messageDtoToResponse(ChatMessage chatMessage) {
        if (Objects.isNull(chatMessage))
            return null;
        return new ChatMessageResponse(
                new EssentialData(
                        chatMessage.getId().getPlayer().getPlayerId(),
                        chatMessage.getId().getPlayer().getUsername()
                ),
                chatMessage.getId().getDate(),
                chatMessage.getBody()
        );
    }
}

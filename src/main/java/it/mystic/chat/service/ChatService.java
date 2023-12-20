package it.mystic.chat.service;

import it.mystic.chat.mapper.ChatMapper;
import it.mystic.chat.model.dto.chat.Chat;
import it.mystic.chat.model.dto.chat.ChatMessage;
import it.mystic.chat.model.dto.pk.PlayerChatPk;
import it.mystic.chat.model.dto.player.Player;
import it.mystic.chat.model.dto.player.PlayerChat;
import it.mystic.chat.model.response.chat.ChatMemberResponse;
import it.mystic.chat.model.response.chat.ChatMessageResponse;
import it.mystic.chat.model.response.chat.ChatResponse;
import it.mystic.chat.repo.chat.ChatRepo;
import it.mystic.chat.repo.chat.ChatMessageRepo;
import it.mystic.chat.repo.player.PlayerChatRepo;
import it.mystic.chat.repo.player.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static it.mystic.chat.util.DateUtil.subtractHours;

@Service
public class ChatService {
    @Autowired
    private ChatRepo chatRepo;
    @Autowired
    private PlayerChatRepo playerChatRepo;
    @Autowired
    private ChatMessageRepo chatMessageRepo;
    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private ChatMapper chatMapper;


    public ChatResponse create(Long playerId, String title) {
        Chat chat = chatMapper.daoToDto(title);
        ChatResponse chatResponse = chatMapper.dtoToResponse(chatRepo.save(chat));
        addAdmin(chat, playerId);
        return chatResponse;
    }

    private void addAdmin(Chat chat, Long playerId){
        Player player = playerRepo.getReferenceById(playerId);
        PlayerChat playerChat =  new PlayerChat(
                new PlayerChatPk(
                        player,
                        chat
                ),
                true
        );
        playerChatRepo.save(playerChat);
    }

    public void update(UUID chatId, String title) {
        Chat chat = chatRepo.getReferenceById(chatId.toString());
        chat.setTitle(title);
        chatRepo.save(chat);
    }

    public List<ChatMemberResponse> getMembers(UUID chatId) {
        Chat chat = chatRepo.getReferenceById(chatId.toString());
        return chatMapper.playerChatListToResponseList(chat.getMembers());
    }

    public List<ChatMessageResponse> getMessages(UUID chatId) {
        Date endDate = new Date();
        Date startDate = subtractHours(endDate, 3);
        return chatMapper.messageListDtoToResponse(chatId.toString(), chatMessageRepo.findByIdDateBetween(startDate, endDate));
    }

    public void delete(UUID chatId) {
        chatRepo.deleteById(chatId.toString());
    }

    private PlayerChatPk getPlayerChatPk(Long playerId, UUID chatId){
        Chat chat = chatRepo.getReferenceById(chatId.toString());
        Player player = playerRepo.getReferenceById(playerId);
        return new PlayerChatPk(player, chat);
    }

    public void addPlayer(UUID chatId, Long playerId) {
        PlayerChatPk playerChatPk = getPlayerChatPk(playerId, chatId);
        PlayerChat playerChat = chatMapper.playerChatDaoToDto(playerChatPk);
        playerChatRepo.save(playerChat);
    }

    public void removePlayer(UUID chatId, Long playerId) {
        PlayerChatPk playerChatPk = getPlayerChatPk(playerId, chatId);
        playerChatRepo.deleteById(playerChatPk);
    }

    public void makeAdmin(UUID chatId, Long playerId) {
        PlayerChatPk playerChatPk = getPlayerChatPk(playerId, chatId);
        PlayerChat playerChat = playerChatRepo.getReferenceById(playerChatPk);
        playerChat.setIsAdmin(true);
        playerChatRepo.save(playerChat);
    }

    public void unmakeAdmin(UUID chatId, Long playerId) {
        PlayerChatPk playerChatPk = getPlayerChatPk(playerId, chatId);
        PlayerChat playerChat = playerChatRepo.getReferenceById(playerChatPk);
        playerChat.setIsAdmin(false);
        playerChatRepo.save(playerChat);
    }

    public ChatMessageResponse sendMessage(UUID chatId, Long playerId, String body) {
        Chat chat = chatRepo.getReferenceById(chatId.toString());
        Player player = playerRepo.getReferenceById(playerId);
        ChatMessage chatMessage = chatMapper.messageToDto(chat, player, body);
        return chatMapper.messageDtoToResponse(chatMessageRepo.save(chatMessage));
    }
}

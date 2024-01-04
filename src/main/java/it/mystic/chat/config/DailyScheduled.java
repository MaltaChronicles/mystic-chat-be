package it.mystic.chat.config;

import it.mystic.chat.model.dto.board.BoardAnswer;
import it.mystic.chat.model.dto.board.BoardDiscussion;
import it.mystic.chat.model.dto.character.Character;
import it.mystic.chat.model.dto.chat.Chat;
import it.mystic.chat.model.dto.chat.ChatMessage;
import it.mystic.chat.model.dto.location.LocationMessage;
import it.mystic.chat.model.dto.location.LocationPoster;
import it.mystic.chat.model.dto.player.Player;
import it.mystic.chat.repo.board.BoardDiscussionRepo;
import it.mystic.chat.repo.character.CharacterRepo;
import it.mystic.chat.repo.chat.ChatMessageRepo;
import it.mystic.chat.repo.chat.ChatRepo;
import it.mystic.chat.repo.location.LocationMessageRepo;
import it.mystic.chat.repo.location.LocationPosterRepo;
import it.mystic.chat.repo.player.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

import static it.mystic.chat.util.CharacterStatsUtil.resetActualStats;
import static it.mystic.chat.util.constant.DateConstant.ONE_MONTH_AGO;
import static it.mystic.chat.util.constant.DateConstant.ONE_YEAR_AGO;

@Component
public class DailyScheduled {
    @Autowired
    private PlayerRepo playerRepo;
    @Autowired
    private CharacterRepo characterRepo;
    @Autowired
    private ChatRepo chatRepo;
    @Autowired
    private ChatMessageRepo chatMessageRepo;
    @Autowired
    private LocationMessageRepo locationMessageRepo;
    @Autowired
    private LocationPosterRepo locationPosterRepo;
    @Autowired
    private BoardDiscussionRepo boardDiscussionRepo;


    @Scheduled(cron = "0 0 4 * * ?")
    public void execute() {
        playerRoutine();
        characterRoutine();
        chatRoutine();
        locationRoutine();
        boardRoutine();
    }

    private void playerRoutine() {
        List<Player> playerList = playerRepo.findAll();

        //LISTA DEI GIOCATORI DA ELIMINARE
        List<Player> playersToDelete = new ArrayList<>();
        playerList.forEach(player -> {
            //SVUOTAMENTO DEI MESSAGGI
            if (Objects.nonNull(player.getMessage()))
                player.setMessage(null);
            //AGGIUNTA DEI GIOCATORI CHE NON ACCEDONO DA UN ANNO
            if (player.getUltimoAccesso().before(ONE_YEAR_AGO))
                playerList.add(player);
        });

        playerRepo.deleteAll(playersToDelete);
    }

    private void characterRoutine() {
        //RESET DEI VALORI DEL PERSONAGGIO
        List<Character> characterList = characterRepo.findAll();
        characterList.forEach(character -> {
            resetActualStats(character.getStatus());
        });
        characterRepo.saveAll(characterList);
    }

    private void chatRoutine() {
        // ELIMINAZIONE DELLA CHAT SE NON CI SONO MEMBRI
        List<Chat> chatList = chatRepo.findAll();
        List<Chat> chatsToDelete = new ArrayList<>();
        chatList.forEach(chat -> {
            if (chat.getMembers().isEmpty())
                chatsToDelete.add(chat);
        });
        chatRepo.deleteAll(chatsToDelete);

        // ELIMINAZIONE DEI MESSAGGI DOPO UN MESE DALL'INVIO
        List<ChatMessage> chatMessageList = chatMessageRepo.findAll();
        List<ChatMessage> messagesToDelete = new ArrayList<>();
        chatMessageList.forEach(chatMessage -> {
            if (chatMessage.getId().getDate().before(ONE_MONTH_AGO))
                messagesToDelete.add(chatMessage);
        });
        chatMessageRepo.deleteAll(messagesToDelete);
    }

    private void locationRoutine() {
        // ELIMINAZIONE DELLA MESSAGGI DOPO UN MESE DAL INVIO
        List<LocationMessage> locationMessageList = locationMessageRepo.findAll();
        List<LocationMessage> messagesToDelete = new ArrayList<>();
        locationMessageList.forEach(locationMessage -> {
            if (locationMessage.getId().getDate().before(ONE_MONTH_AGO))
                messagesToDelete.add(locationMessage);
        });
        locationMessageRepo.deleteAll(messagesToDelete);

        // ELIMINAZIONE DEI POSTER NON FISSATI DOPO UN MESE
        List<LocationPoster> locationPosterList = locationPosterRepo.findAll();
        List<LocationPoster> postersToDelete = new ArrayList<>();
        locationPosterList.forEach(locationPoster -> {
            if (!locationPoster.getIsPin() && locationPoster.getDate().before(ONE_MONTH_AGO))
                postersToDelete.add(locationPoster);
        });
        locationPosterRepo.deleteAll(postersToDelete);
    }

    private void boardRoutine() {
        // ELIMINAZIONE DELLE DISCUSSIONI CHIUSE NON FISSATE DOPO UN MESE DI INATTIVITA'
        List<BoardDiscussion> boardDiscussionList = boardDiscussionRepo.findAll();
        List<BoardDiscussion> discussionsToDelete = new ArrayList<>();
        boardDiscussionList.forEach(boardDiscussion -> {
            if (!boardDiscussion.getIsPin() && !boardDiscussion.getIsOpen() && findLastAnswerDate(boardDiscussion).before(ONE_MONTH_AGO))
                discussionsToDelete.add(boardDiscussion);
        });
        boardDiscussionRepo.deleteAll(discussionsToDelete);
    }

    private Date findLastAnswerDate(BoardDiscussion boardDiscussion) {
        Optional<Date> maxDate = boardDiscussion.getAnswers().stream()
                .map(BoardAnswer::getAnswerDate)
                .max(Date::compareTo);

        return maxDate.orElseGet(boardDiscussion::getOpenDate);
    }

    private void logRoutine() {
        //ELIMINAZIONE DEI LOG DOPO 3 MESI
        //TODO
    }
}

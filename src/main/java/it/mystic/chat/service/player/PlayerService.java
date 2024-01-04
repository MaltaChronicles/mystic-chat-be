package it.mystic.chat.service.player;

import it.mystic.chat.exception.GenericException;
import it.mystic.chat.exception.ValidationException;
import it.mystic.chat.mapper.PlayerMapper;
import it.mystic.chat.model.dao.PlayerDao;
import it.mystic.chat.model.dto.character.Character;
import it.mystic.chat.model.dto.player.Player;
import it.mystic.chat.model.response.EssentialData;
import it.mystic.chat.model.response.player.PlayerResponse;
import it.mystic.chat.repo.character.CharacterRepo;
import it.mystic.chat.repo.player.PlayerRepo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepo playerRepo;
    @Autowired
    private CharacterRepo characterRepo;
    @Autowired
    private PlayerMapper playerMapper;

    public PlayerResponse create(PlayerDao playerDao) throws ValidationException {
        validate(playerDao);
        Player player = playerMapper.daoToDto(playerDao);
        return playerMapper.dtoToResponse(playerRepo.save(player));
    }

    public PlayerResponse getById(Long userId) {
        return playerMapper.dtoToResponse(playerRepo.getReferenceById(userId));
    }

    public List<EssentialData> getAll() {
        return playerMapper.playerListToMap(playerRepo.findAll());
    }

    public void deleteById(Long playerId) {
        playerRepo.deleteById(playerId);
    }

    /* VALIDAZIONE*/
    private void validate(PlayerDao playerDao) {
        usernameNotUsed(playerDao.username());
        emailNotUsed(playerDao.email());
    }

    private void usernameNotUsed(String username) {
        if (playerRepo.existsByUsername(StringUtils.capitalize(username))) {
            throw new ValidationException("username", "username già in uso");
        }
    }

    private void emailNotUsed(String email) {
        if (playerRepo.existsByEmail(email.toLowerCase())) {
            throw new ValidationException("email", "email già in uso");
        }
    }
    /* FINE VALIDAZIONE*/

    public void addCharacter(Long playerId, Long characterId) throws GenericException {
        Player player = playerRepo.getReferenceById(playerId);
        Character character = characterRepo.getReferenceById(characterId);

        Character character1 = player.getCharacter1();
        Character character2 = player.getCharacter2();
        Character character3 = player.getCharacter3();
        
        if (Objects.isNull(character1))
            player.setCharacter1(character);
        else if (Objects.isNull(character2))
            player.setCharacter2(character);
        else if (Objects.isNull(character3))
            player.setCharacter3(character);
        else
            throw new GenericException("Non è possibile avere più di 3 personaggi!");
        playerRepo.save(player);
    }

    public void updateEmail(Long playerId, String email) {
        emailNotUsed(email);
        Player player = playerRepo.getReferenceById(playerId);
        player.setEmail(email.toLowerCase());
        playerRepo.save(player);
    }

    public void updatePassword(Long playerId, String password) {
        Player player = playerRepo.getReferenceById(playerId);
        player.setPassword(password);
        playerRepo.save(player);
    }

    public List<EssentialData> getAllLikeUsername(String username) {
        username = "%" + username + "%";
        return playerMapper.playerListToMap(playerRepo.findByUsernameIgnoreCaseLike(username));
    }

    public void updateUltimaAzione(Long playerId) {
        Player player = playerRepo.getReferenceById(playerId);
        player.setUltimaAzione(new Date());
        playerRepo.save(player);
    }

    public void updateMessage(Long playerId, String message) {
        Player player = playerRepo.getReferenceById(playerId);
        player.setMessage(message);
        playerRepo.save(player);
    }
}

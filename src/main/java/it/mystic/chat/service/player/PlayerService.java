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
        if (playerRepo.existsByUsername(username)) {
            throw new ValidationException("username", "username già in uso");
        }
    }

    private void emailNotUsed(String email) {
        if (playerRepo.existsByEmail(email)) {
            throw new ValidationException("email", "email già in uso");
        }
    }
    /* FINE VALIDAZIONE*/

    public Player addCharacter(Long playerId, Long characterId) throws GenericException {
        Player player = playerRepo.getReferenceById(playerId);
        Character character = characterRepo.getReferenceById(characterId);
        if (Objects.nonNull(player.getCharacter1()))
            player.setCharacter1(character);
        else if (Objects.nonNull(player.getCharacter2()))
            player.setCharacter2(character);
        else if (Objects.nonNull(player.getCharacter3()))
            player.setCharacter3(character);
        else
            throw new GenericException("Non è possibile avere più di 3 personaggi!");
        return playerRepo.save(player);
    }

    public void updateEmail(Long playerId, String email) {
        emailNotUsed(email);
        Player player = playerRepo.getReferenceById(playerId);
        player.setEmail(email);
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
}

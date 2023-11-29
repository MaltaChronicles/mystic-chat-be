package it.mystic.chat.service;

import it.mystic.chat.exception.GenericException;
import it.mystic.chat.exception.ValidationException;
import it.mystic.chat.mapper.PlayerMapper;
import it.mystic.chat.model.dao.PlayerDao;
import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.dto.Player;
import it.mystic.chat.repo.CharacterRepo;
import it.mystic.chat.repo.PlayerRepo;
import it.mystic.chat.util.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private BeanValidator validator;

    public Player create(PlayerDao playerDao) throws ValidationException {
        validate(playerDao);
        Player player = playerMapper.daoTo(playerDao);
        return playerRepo.save(player);
    }

    public Player getById(Long userId) {
        return playerRepo.getReferenceById(userId);
    }

    public List<Player> getAll() {
        return playerRepo.findAll();
    }

    public void update(PlayerDao playerDao) {
        validate(playerDao);
        Player player = playerRepo.getReferenceById(playerDao.getId());
        player.setUsername(playerDao.getUsername());
        player.setPassword(playerDao.getPassword());
        player.setEmail(playerDao.getEmail());
        playerRepo.save(player);
    }

    public void deleteById(Long playerId) {
        playerRepo.deleteById(playerId);
    }

    /* VALIDAZIONE*/
    private void validate(PlayerDao playerDao) {
        validator.validate(playerDao);
        usernameNotUsed(playerDao.getUsername());
        emailNotUsed(playerDao.getEmail());
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
}

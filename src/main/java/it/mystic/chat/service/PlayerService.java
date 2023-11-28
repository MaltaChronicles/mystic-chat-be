package it.mystic.chat.service;

import it.mystic.chat.exception.GenericException;
import it.mystic.chat.exception.ValidationException;
import it.mystic.chat.mapper.PlayerMapper;
import it.mystic.chat.model.dao.PlayerDao;
import it.mystic.chat.model.dto.CharacterDto;
import it.mystic.chat.model.dto.PlayerDto;
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

    public PlayerDto create(PlayerDao playerDao) throws ValidationException {
        validate(playerDao);
        PlayerDto playerDto = playerMapper.daoToDto(playerDao);
        return playerRepo.save(playerDto);
    }

    public PlayerDto getById(Long userId) {
        return playerRepo.getReferenceById(userId);
    }

    public List<PlayerDto> getAll() {
        return playerRepo.findAll();
    }

    public void update(PlayerDao playerDao) {
        validate(playerDao);
        PlayerDto playerDto = playerRepo.getReferenceById(playerDao.getId());
        playerDto.setUsername(playerDao.getUsername());
        playerDto.setPassword(playerDao.getPassword());
        playerDto.setEmail(playerDao.getEmail());
        playerRepo.save(playerDto);
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

    public PlayerDto addCharacter(Long playerId, Long characterId) throws GenericException {
        PlayerDto playerDto = playerRepo.getReferenceById(playerId);
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (Objects.nonNull(playerDto.getCharacter1()))
            playerDto.setCharacter1(characterDto);
        else if (Objects.nonNull(playerDto.getCharacter2()))
            playerDto.setCharacter2(characterDto);
        else if (Objects.nonNull(playerDto.getCharacter3()))
            playerDto.setCharacter3(characterDto);
        else
            throw new GenericException("Non è possibile avere più di 3 personaggi!");
        return playerRepo.save(playerDto);
    }
}

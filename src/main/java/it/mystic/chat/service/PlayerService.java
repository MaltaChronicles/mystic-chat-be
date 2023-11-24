package it.mystic.chat.service;

import it.mystic.chat.exception.ValidationException;
import it.mystic.chat.mapper.PlayerMapper;
import it.mystic.chat.model.dao.PlayerDao;
import it.mystic.chat.model.dto.PlayerDto;
import it.mystic.chat.repo.PlayerRepo;
import it.mystic.chat.util.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepo playerRepo;
    @Autowired
    private PlayerMapper playerMapper;
    @Autowired
    private BeanValidator validator;

    public PlayerDto create(PlayerDao playerDao) throws ValidationException {
        validate(playerDao);
        PlayerDto playerDto = playerMapper.daoToDto(playerDao);
        return playerRepo.save(playerDto);
    }

    public PlayerDto readById(Long userId) {
        return playerRepo.getReferenceById(userId);
    }

    public List<PlayerDto> readAll() {
        return playerRepo.findAll();
    }

    public PlayerDto update(PlayerDao playerDao) {
        validate(playerDao);
        PlayerDto playerDto = playerMapper.daoToDto(playerDao);
        return playerRepo.save(playerDto);
    }

    public void deleteById(Long userId) {
        playerRepo.deleteById(userId);
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

}

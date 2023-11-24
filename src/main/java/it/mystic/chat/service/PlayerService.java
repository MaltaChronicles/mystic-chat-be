package it.mystic.chat.service;

import it.mystic.chat.mapper.PlayerMapper;
import it.mystic.chat.model.dao.PlayerDao;
import it.mystic.chat.model.dto.PlayerDto;
import it.mystic.chat.repo.PlayerRepo;
import it.mystic.chat.util.BeanValidator;
import jakarta.validation.Valid;
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

    public PlayerDto create(PlayerDao playerDao) {
        //TODO aggiungere controlli di esistenza mail e username
        validator.validate(playerDao);
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
        PlayerDto playerDto = playerMapper.daoToDto(playerDao);
        return playerRepo.save(playerDto);
    }
    public void deleteById(Long userId) {
        playerRepo.deleteById(userId);
    }


}

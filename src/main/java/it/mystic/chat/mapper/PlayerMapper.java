package it.mystic.chat.mapper;


import it.mystic.chat.model.dao.PlayerDao;
import it.mystic.chat.model.dto.PlayerDto;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class PlayerMapper {

    public PlayerDto daoToDto(PlayerDao playerDao) {
        return new PlayerDto(
                playerDao.getId(),
                playerDao.getUsername(),
                playerDao.getPassword(),
                playerDao.getEmail(),
                new Date(),
                null,
                null,
                null,null, null
        );
    }

}

package it.mystic.chat.mapper;


import it.mystic.chat.model.dao.PlayerDao;
import it.mystic.chat.model.dto.Player;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class PlayerMapper {

    public Player daoTo(PlayerDao playerDao) {
        return new Player(
                playerDao.getId(),
                playerDao.getUsername(),
                playerDao.getPassword(),
                playerDao.getEmail(),
                new Date(),
                null,
                null,
                null,
                null,
                null, null,null,
                null,
                null
        );
    }

}

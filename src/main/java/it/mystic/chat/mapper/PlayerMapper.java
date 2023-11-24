package it.mystic.chat.mapper;


import it.mystic.chat.model.dao.PlayerDao;
import it.mystic.chat.model.dto.PlayerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PlayerMapper {

    public PlayerDto daoToDto(PlayerDao playerDao){
        PlayerDto playerDto = new PlayerDto(
                playerDao.username(),
                playerDao.password(),
                playerDao.email()
        );
        playerDto.setId(playerDto.getId());
        return playerDto;
    };
}

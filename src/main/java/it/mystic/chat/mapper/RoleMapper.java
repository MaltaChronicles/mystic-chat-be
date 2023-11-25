package it.mystic.chat.mapper;


import it.mystic.chat.model.dao.RoleDao;
import it.mystic.chat.model.dto.PlayerRoleDto;
import org.springframework.stereotype.Component;


@Component
public class RoleMapper {

    public PlayerRoleDto daoToDto(RoleDao roleDao) {
        PlayerRoleDto playerRoleDto = new PlayerRoleDto(
                roleDao.getPlayerId(),
                roleDao.getRole()
        );
        playerRoleDto.setIsBoss(roleDao.getIsBoss());
        return playerRoleDto;
    }

}

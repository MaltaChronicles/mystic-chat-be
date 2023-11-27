package it.mystic.chat.mapper;


import it.mystic.chat.model.dao.RoleDao;
import it.mystic.chat.model.dto.PlayerDto;
import it.mystic.chat.model.dto.PlayerRoleDto;
import it.mystic.chat.model.dto.pk.RolePk;
import org.springframework.stereotype.Component;


@Component
public class RoleMapper {

    public PlayerRoleDto daoToDto(RoleDao roleDao, PlayerDto playerDto) {
        return new PlayerRoleDto(
                new RolePk(playerDto, roleDao.getRole()),
                roleDao.getIsBoss()
        );
    }

}

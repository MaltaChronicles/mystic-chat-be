package it.mystic.chat.mapper;


import it.mystic.chat.model.dao.RoleDao;
import it.mystic.chat.model.dto.Player;
import it.mystic.chat.model.dto.PlayerRole;
import it.mystic.chat.model.dto.pk.PlayerRolePk;
import org.springframework.stereotype.Component;


@Component
public class RoleMapper {

    public PlayerRole daoTo(RoleDao roleDao, Player player) {
        return new PlayerRole(
                new PlayerRolePk(player, roleDao.getRole()),
                roleDao.getIsBoss()
        );
    }

}

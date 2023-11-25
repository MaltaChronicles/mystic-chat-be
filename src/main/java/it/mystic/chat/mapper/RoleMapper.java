package it.mystic.chat.mapper;


import it.mystic.chat.model.dao.RoleDao;
import it.mystic.chat.model.dto.RoleDto;
import org.springframework.stereotype.Component;


@Component
public class RoleMapper {

    public RoleDto daoToDto(RoleDao roleDao) {
        RoleDto roleDto = new RoleDto(
                roleDao.getPlayerId(),
                roleDao.getRole()
        );
        roleDto.setIsBoss(roleDao.getIsBoss());
        return roleDto;
    }

}

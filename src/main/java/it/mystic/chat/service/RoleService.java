package it.mystic.chat.service;

import it.mystic.chat.mapper.RoleMapper;
import it.mystic.chat.model.dao.RoleDao;
import it.mystic.chat.model.dto.PlayerDto;
import it.mystic.chat.model.dto.PlayerRoleDto;
import it.mystic.chat.repo.PlayerRepo;
import it.mystic.chat.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private RoleMapper roleMapper;

    public PlayerRoleDto create(RoleDao roleDao) {
        PlayerRoleDto playerRoleDto = roleMapper.daoToDto(roleDao, getPlayer(roleDao));
        return roleRepo.save(playerRoleDto);
    }

    public void update(RoleDao roleDao) {
        PlayerRoleDto playerRoleDto = roleMapper.daoToDto(roleDao, getPlayer(roleDao));
        roleRepo.save(playerRoleDto);
    }

    public void deleteById(RoleDao roleDao) {
        PlayerRoleDto playerRoleDto = roleMapper.daoToDto(roleDao, getPlayer(roleDao));
        roleRepo.deleteById(playerRoleDto.getId());
    }

    private PlayerDto getPlayer(RoleDao roleDao){
        return playerRepo.getReferenceById(roleDao.getPlayerId());
    }
}

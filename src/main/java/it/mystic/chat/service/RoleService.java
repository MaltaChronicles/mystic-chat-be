package it.mystic.chat.service;

import it.mystic.chat.mapper.RoleMapper;
import it.mystic.chat.model.dao.RoleDao;
import it.mystic.chat.model.dto.PlayerRoleDto;
import it.mystic.chat.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private RoleMapper roleMapper;

    public PlayerRoleDto create(RoleDao roleDao) {
        PlayerRoleDto playerRoleDto = roleMapper.daoToDto(roleDao);
        return roleRepo.save(playerRoleDto);
    }

    public PlayerRoleDto update(RoleDao roleDao) {
        PlayerRoleDto playerRoleDto = roleMapper.daoToDto(roleDao);
        return roleRepo.save(playerRoleDto);
    }

    public void deleteById(RoleDao roleDao) {
        PlayerRoleDto playerRoleDto = roleMapper.daoToDto(roleDao);
        roleRepo.deleteById(playerRoleDto.getId());
    }
}

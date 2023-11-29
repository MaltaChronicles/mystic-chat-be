package it.mystic.chat.service;

import it.mystic.chat.mapper.RoleMapper;
import it.mystic.chat.model.dao.RoleDao;
import it.mystic.chat.model.dto.Player;
import it.mystic.chat.model.dto.PlayerRole;
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

    public PlayerRole create(RoleDao roleDao) {
        PlayerRole playerRole = roleMapper.daoTo(roleDao, getPlayer(roleDao));
        return roleRepo.save(playerRole);
    }

    public void update(RoleDao roleDao) {
        PlayerRole playerRole = roleMapper.daoTo(roleDao, getPlayer(roleDao));
        roleRepo.save(playerRole);
    }

    public void deleteById(RoleDao roleDao) {
        PlayerRole playerRole = roleMapper.daoTo(roleDao, getPlayer(roleDao));
        roleRepo.deleteById(playerRole.getId());
    }

    private Player getPlayer(RoleDao roleDao) {
        return playerRepo.getReferenceById(roleDao.getPlayerId());
    }
}

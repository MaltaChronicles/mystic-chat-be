package it.mystic.chat.service;

import it.mystic.chat.mapper.RoleMapper;
import it.mystic.chat.model.dao.RoleDao;
import it.mystic.chat.model.dto.RoleDto;
import it.mystic.chat.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private RoleMapper roleMapper;

    public RoleDto create(RoleDao roleDao) {
        RoleDto roleDto = roleMapper.daoToDto(roleDao);
        return roleRepo.save(roleDto);
    }

    public RoleDto update(RoleDao roleDao) {
        RoleDto roleDto = roleMapper.daoToDto(roleDao);
        return roleRepo.save(roleDto);
    }

    public void deleteById(RoleDao roleDao) {
        RoleDto roleDto = roleMapper.daoToDto(roleDao);
        roleRepo.deleteById(roleDto.getId());
    }
}

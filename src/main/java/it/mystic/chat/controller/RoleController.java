package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.RoleDao;
import it.mystic.chat.model.dto.PlayerRoleDto;
import it.mystic.chat.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/off/role")
@Tag(name = "ROLE")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<PlayerRoleDto> createRole(@RequestBody RoleDao roleDao) {
        PlayerRoleDto playerRoleDto = roleService.create(roleDao);
        return ResponseEntity.ok(playerRoleDto);
    }

    @PatchMapping("/changeBoss")
    public ResponseEntity<Void> updateRole(@RequestBody RoleDao roleDao) {
        roleService.update(roleDao);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<Void> deleteRoleById(@RequestBody RoleDao roleDao) {
        roleService.deleteById(roleDao);
        return ResponseEntity.ok().build();
    }

}

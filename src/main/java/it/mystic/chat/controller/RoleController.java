package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.RoleDao;
import it.mystic.chat.model.dto.RoleDto;
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
    public ResponseEntity<Object> createRole(@RequestBody RoleDao roleDao) {
        RoleDto roleDto = roleService.create(roleDao);
        return ResponseEntity.ok(roleDto);
    }

    @PatchMapping("/changeBoss")
    public ResponseEntity<Object> updateRole(@RequestBody RoleDao roleDao) {
        RoleDto roleDto = roleService.update(roleDao);
        return ResponseEntity.ok(roleDto);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<Object> deleteRoleById(@RequestBody RoleDao roleDao) {
        roleService.deleteById(roleDao);
        return ResponseEntity.ok().build();
    }

}

package it.mystic.chat.repo;

import it.mystic.chat.model.dto.CharacterInventory;
import it.mystic.chat.model.dto.pk.CharacterInventoryPk;
import it.mystic.chat.service.CharacterInventoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CharacterInventoryRepo extends JpaRepository<CharacterInventory, CharacterInventoryPk> {
}

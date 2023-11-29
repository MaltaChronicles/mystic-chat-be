package it.mystic.chat.repo;

import it.mystic.chat.model.dto.CharacterInventory;
import it.mystic.chat.model.dto.pk.CharacterInventoryPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterInventoryRepo extends JpaRepository<CharacterInventory, CharacterInventoryPk> {
}

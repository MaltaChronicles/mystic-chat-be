package it.mystic.chat.repo.character;

import it.mystic.chat.model.dto.character.CharacterInventory;
import it.mystic.chat.model.dto.pk.CharacterInventoryPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterInventoryRepo extends JpaRepository<CharacterInventory, CharacterInventoryPk> {
}

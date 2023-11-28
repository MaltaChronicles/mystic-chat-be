package it.mystic.chat.repo;

import it.mystic.chat.model.dto.CharacterInventoryDto;
import it.mystic.chat.model.dto.pk.CharacterInventoryPk;
import it.mystic.chat.service.CharacterInventoryService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterInventoryRepo extends JpaRepository<CharacterInventoryDto, CharacterInventoryPk> {
    CharacterInventoryDto getReferenceByCharacterIdAndObjectId(Long characterId, Long objectId);
}

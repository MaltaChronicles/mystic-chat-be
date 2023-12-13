package it.mystic.chat.repo.character;

import it.mystic.chat.model.dto.character.CharacterAbilityThree;
import it.mystic.chat.model.dto.pk.CharacterAbilityThreePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterAbilityThreeRepo extends JpaRepository<CharacterAbilityThree, CharacterAbilityThreePk> {
}

package it.mystic.chat.repo;

import it.mystic.chat.model.dto.CharacterAbilityThree;
import it.mystic.chat.model.dto.pk.CharacterAbilityThreePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterAbilityThreeRepo extends JpaRepository<CharacterAbilityThree, CharacterAbilityThreePk> {
}

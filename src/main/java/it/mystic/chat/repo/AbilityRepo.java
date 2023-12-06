package it.mystic.chat.repo;

import it.mystic.chat.model.dto.Ability;
import it.mystic.chat.model.enums.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbilityRepo extends JpaRepository<Ability, Long> {
    List<Ability> getReferenceByAbilityClass(Class abilityClass);
}

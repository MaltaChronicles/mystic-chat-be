package it.mystic.chat.repo;

import it.mystic.chat.model.dto.Ability;
import it.mystic.chat.model.enums.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbilityRepo extends JpaRepository<Ability, Long> {
    List<Ability> getReferenceByAbilityClass(Class abilityClass);
}

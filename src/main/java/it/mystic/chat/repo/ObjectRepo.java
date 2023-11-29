package it.mystic.chat.repo;

import it.mystic.chat.model.dto.Object;
import it.mystic.chat.model.enums.ObjectType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObjectRepo extends JpaRepository<Object, Long> {
    List<Object> getAllByType(ObjectType objectType);
}

package it.mystic.chat.repo;

import it.mystic.chat.model.dto.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location, Long> {
}

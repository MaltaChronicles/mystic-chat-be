package it.mystic.chat.repo.location;

import it.mystic.chat.model.dto.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location, Long> {
}

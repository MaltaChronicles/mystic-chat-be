package it.mystic.chat.repo;

import it.mystic.chat.model.dto.Medal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedalRepo extends JpaRepository<Medal, Long> {
}

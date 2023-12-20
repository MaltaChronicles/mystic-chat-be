package it.mystic.chat.repo;

import it.mystic.chat.model.dto.Medal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedalRepo extends JpaRepository<Medal, Long> {
}

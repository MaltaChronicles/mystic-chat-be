package it.mystic.chat.repo;

import it.mystic.chat.model.dto.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepo extends JpaRepository<Configuration, String> {
}

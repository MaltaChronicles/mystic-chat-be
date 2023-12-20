package it.mystic.chat.repo.location;

import it.mystic.chat.model.dto.location.Location;
import it.mystic.chat.model.dto.location.LocationEvent;
import it.mystic.chat.model.dto.pk.LocationEventPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationEventRepo extends JpaRepository<LocationEvent, LocationEventPk> {
    List<LocationEvent> findByIdLocation(Location location);
}

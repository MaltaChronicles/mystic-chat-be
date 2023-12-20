package it.mystic.chat.repo.location;

import it.mystic.chat.model.dto.location.Location;
import it.mystic.chat.model.dto.location.LocationPoster;
import it.mystic.chat.model.dto.pk.LocationPosterPk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationPosterRepo extends JpaRepository<LocationPoster, LocationPosterPk> {
    List<LocationPoster> getByIdLocation(Location location);
}

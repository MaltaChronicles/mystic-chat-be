package it.mystic.chat.repo.location;

import it.mystic.chat.model.dto.location.Location;
import it.mystic.chat.model.dto.location.LocationPoster;
import it.mystic.chat.model.dto.pk.LocationPosterPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationPosterRepo extends JpaRepository<LocationPoster, LocationPosterPk> {
    List<LocationPoster> getByIdLocation(Location location);
}

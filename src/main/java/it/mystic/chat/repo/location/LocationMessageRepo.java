package it.mystic.chat.repo.location;

import it.mystic.chat.model.dto.location.LocationMessage;
import it.mystic.chat.model.dto.pk.LocationMessagePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LocationMessageRepo extends JpaRepository<LocationMessage, LocationMessagePk> {
    List<LocationMessage> findByIdDateBetween(Date startDate, Date endDate);
}

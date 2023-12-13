package it.mystic.chat.repo.location;

import it.mystic.chat.model.dto.location.LocationMessage;
import it.mystic.chat.model.dto.pk.LocationMessagePk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface LocationMessageRepo extends JpaRepository<LocationMessage, LocationMessagePk> {
    List<LocationMessage> findByIdDataBetween(Date startDate, Date endDate);
}

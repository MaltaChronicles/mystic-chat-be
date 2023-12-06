package it.mystic.chat.mapper;

import it.mystic.chat.model.dao.LocationEventDao;
import it.mystic.chat.model.dto.Location;
import it.mystic.chat.model.dto.LocationEvent;
import it.mystic.chat.model.dto.pk.LocationEventPk;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LocationEventMapper {

    public LocationEvent daoToDto(Location location, LocationEventDao locationEventDao) {
        return new LocationEvent(
                new LocationEventPk(location, new Date()),
                locationEventDao.getName(),
                locationEventDao.getDescription(),
                locationEventDao.getCreateBy()
        );
    }
}

package it.mystic.chat.mapper;

import it.mystic.chat.model.dao.LocationMessageDao;
import it.mystic.chat.model.dto.Location;
import it.mystic.chat.model.dto.LocationMessage;
import it.mystic.chat.model.dto.pk.LocationMessagePk;
import it.mystic.chat.model.enums.MessageType;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LocationMessageMapper {

    public LocationMessage daoToDto(Location location, MessageType messageType, LocationMessageDao locationMessageDao) {
        return new LocationMessage(
                new LocationMessagePk(
                        location,
                        locationMessageDao.getSender(),
                        new Date()
                ),
                messageType,
                locationMessageDao.getTag(),
                locationMessageDao.getBody(),
                locationMessageDao.getImageLink()
        );
    }
}

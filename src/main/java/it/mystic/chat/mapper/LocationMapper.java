package it.mystic.chat.mapper;

import it.mystic.chat.model.dao.LocationDao;
import it.mystic.chat.model.dao.LocationEventDao;
import it.mystic.chat.model.dao.LocationMessageDao;
import it.mystic.chat.model.dto.Location;
import it.mystic.chat.model.dto.LocationEvent;
import it.mystic.chat.model.dto.LocationMessage;
import it.mystic.chat.model.dto.pk.LocationEventPk;
import it.mystic.chat.model.dto.pk.LocationMessagePk;
import it.mystic.chat.model.enums.MessageType;
import it.mystic.chat.model.response.LocationEventResponse;
import it.mystic.chat.model.response.LocationMessageResponse;
import it.mystic.chat.model.response.LocationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class LocationMapper {
    @Value("${upload.dir}")
    private String uploadDir;

    public Location daoToDto(LocationDao locationDao) {
        return new Location(
                null,
                locationDao.getName(),
                locationDao.getDescription(),
                uploadDir + "img/location/icon/default.jpeg",
                uploadDir + "img/location/background/default.jpeg",
                uploadDir + "mp3/location/default.mp3",
                null,
                null,
                null
        );
    }

    public LocationEvent eventDaoToDto(Location location, LocationEventDao locationEventDao) {
        return new LocationEvent(
                new LocationEventPk(location, new Date()),
                locationEventDao.getName(),
                locationEventDao.getDescription(),
                locationEventDao.getCreateBy()
        );
    }

    public LocationMessage messageDaoToDto(Location location, MessageType messageType, LocationMessageDao locationMessageDao) {
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

    public LocationResponse dtoToResponse(Location location) {
        return new LocationResponse(
                location.getLocationId(),
                location.getName(),
                location.getDescription(),
                location.getImageUrl(),
                location.getBackgroundUrl(),
                location.getAmbientUrl()
        );
    }

    public List<LocationEventResponse> eventDtoToResponse(List<LocationEvent> locationEventList) {
        return locationEventList.stream().map(event -> {
            return new LocationEventResponse(
                    event.getId().getData(),
                    event.getName(),
                    event.getDescription(),
                    event.getCreateBy()
            );
        }).toList();
    }

    public List<LocationMessageResponse> messageDtoToResponse(Long locationId, List<LocationMessage> locationMessageList) {
        return locationMessageList.stream().filter(locationMessage -> {
            return locationMessage.getId().getLocation().getLocationId() == locationId;
        }).map(message -> {
            return new LocationMessageResponse(
                    message.getId().getSender(),
                    message.getId().getData(),
                    message.getMessageType(),
                    message.getTag(),
                    message.getBody(),
                    message.getImageLink()
            );
        }).toList();
    }
}

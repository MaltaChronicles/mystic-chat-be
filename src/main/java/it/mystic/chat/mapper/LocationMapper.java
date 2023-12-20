package it.mystic.chat.mapper;

import it.mystic.chat.model.dao.location.LocationDao;
import it.mystic.chat.model.dao.location.LocationEventDao;
import it.mystic.chat.model.dao.location.LocationMessageDao;
import it.mystic.chat.model.dao.location.LocationPosterDao;
import it.mystic.chat.model.dto.character.Character;
import it.mystic.chat.model.dto.location.Location;
import it.mystic.chat.model.dto.location.LocationEvent;
import it.mystic.chat.model.dto.location.LocationMessage;
import it.mystic.chat.model.dto.location.LocationPoster;
import it.mystic.chat.model.dto.pk.LocationEventPk;
import it.mystic.chat.model.dto.pk.LocationMessagePk;
import it.mystic.chat.model.dto.pk.PosterPk;
import it.mystic.chat.model.enums.MessageType;
import it.mystic.chat.model.response.location.LocationEventResponse;
import it.mystic.chat.model.response.location.LocationMessageResponse;
import it.mystic.chat.model.response.location.LocationPosterResponse;
import it.mystic.chat.model.response.location.LocationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class LocationMapper {
    @Value("${upload.dir}")
    private String uploadDir;

    public Location daoToDto(LocationDao locationDao) {
        if(Objects.isNull(locationDao))
            return null;
        return new Location(
                null,
                locationDao.getName(),
                locationDao.getDescription(),
                uploadDir + "img/location/icon/default.jpeg",
                uploadDir + "img/location/background/default.jpeg",
                uploadDir + "mp3/location/default.mp3",
                null,
                null,
                null,
                null
        );
    }

    public LocationEvent eventDaoToDto(Location location, LocationEventDao locationEventDao) {
        if(Objects.isNull(location) || Objects.isNull(locationEventDao))
            return null;
        return new LocationEvent(
                new LocationEventPk(location, new Date()),
                locationEventDao.getName(),
                locationEventDao.getDescription(),
                locationEventDao.getCreateBy()
        );
    }

    public LocationMessage messageDaoToDto(Location location, MessageType messageType, LocationMessageDao locationMessageDao) {
        if(Objects.isNull(location) || Objects.isNull(messageType) || Objects.isNull(locationMessageDao))
            return null;
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
        if(Objects.isNull(location))
            return null;
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
        if(Objects.isNull(locationEventList))
            return null;
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
        if(Objects.isNull(locationMessageList) || Objects.isNull(locationId))
            return null;
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

    public LocationPoster locationDaoToDto(Character character, Location location, LocationPosterDao locationPosterDao) {
        if(Objects.isNull(character) || Objects.isNull(location) || Objects.isNull(locationPosterDao))
            return null;
        return new LocationPoster(
                new PosterPk(UUID.randomUUID().toString(), character, location),
                locationPosterDao.title(),
                locationPosterDao.body(),
                new Date()
        );
    }

    public LocationPosterResponse locationDtoToResponse(LocationPoster locationPoster) {
        if(Objects.isNull(locationPoster))
            return null;
        return new LocationPosterResponse(
                locationPoster.getId().getCharacter().getCharacterId(),
                locationPoster.getId().getLocation().getLocationId(),
                locationPoster.getId().getUuid(),
                locationPoster.getTitle(),
                locationPoster.getBody(),
                locationPoster.getDate()
        );
    }

    public List<LocationPosterResponse> locationDtoListToResponseList(List<LocationPoster> locationPosterList) {
        if(Objects.isNull(locationPosterList))
            return null;
        return locationPosterList.stream().map(this::locationDtoToResponse).toList();
    }
}

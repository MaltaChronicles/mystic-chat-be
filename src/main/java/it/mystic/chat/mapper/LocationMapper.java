package it.mystic.chat.mapper;

import it.mystic.chat.model.dao.LocationDao;
import it.mystic.chat.model.dto.Location;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {
    @Value("${upload.dir}")
    private String uploadDir;

    public Location daoToDto(LocationDao locationDao){
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
}

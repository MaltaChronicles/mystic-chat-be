package it.mystic.chat.service.location;

import it.mystic.chat.mapper.LocationMapper;
import it.mystic.chat.model.dao.location.LocationEventDao;
import it.mystic.chat.model.dto.location.Location;
import it.mystic.chat.model.dto.location.LocationEvent;
import it.mystic.chat.model.dto.pk.LocationEventPk;
import it.mystic.chat.model.response.location.LocationEventResponse;
import it.mystic.chat.repo.location.LocationEventRepo;
import it.mystic.chat.repo.location.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static it.mystic.chat.util.DateUtil.convertLocalDateTimeToDate;

@Service
public class LocationEventService {

    @Autowired
    private LocationEventRepo locationEventRepo;
    @Autowired
    private LocationRepo locationRepo;

    @Autowired
    private LocationMapper locationMapper;

    public void addEvent(Long locationId, LocationEventDao locationEventDao) {
        Location location = locationRepo.getReferenceById(locationId);
        LocationEvent locationEvent = locationMapper.eventDaoToDto(location, locationEventDao);
        locationEventRepo.save(locationEvent);
    }

    public void update(Long locationId, LocalDateTime date, LocationEventDao locationEventDao) {
        Location location = locationRepo.getReferenceById(locationId);
        LocationEvent locationEvent = locationEventRepo.getReferenceById(new LocationEventPk(location, convertLocalDateTimeToDate(date)));
        locationEvent.setName(locationEventDao.name());
        locationEvent.setDescription(locationEventDao.description());
        locationEvent.setCreateBy(locationEventDao.createBy());
        locationEventRepo.save(locationEvent);
    }

    public void delete(Long locationId, LocalDateTime date, LocationEventDao locationEventDao) {
        Location location = locationRepo.getReferenceById(locationId);
        locationEventRepo.deleteById(new LocationEventPk(location, convertLocalDateTimeToDate(date)));
    }

    public List<LocationEventResponse> getAllByLocation(Long locationId) {
        Location location = locationRepo.getReferenceById(locationId);
        return locationMapper.eventDtoToResponse(locationEventRepo.findByIdLocation(location));
    }
}

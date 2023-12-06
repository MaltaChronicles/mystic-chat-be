package it.mystic.chat.service;

import it.mystic.chat.mapper.LocationEventMapper;
import it.mystic.chat.model.dao.LocationEventDao;
import it.mystic.chat.model.dto.Location;
import it.mystic.chat.model.dto.LocationEvent;
import it.mystic.chat.model.dto.pk.LocationEventPk;
import it.mystic.chat.repo.LocationEventRepo;
import it.mystic.chat.repo.LocationRepo;
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
    private LocationEventMapper locationEventMapper;

    public void addEvent(Long locationId, LocationEventDao locationEventDao) {
        Location location = locationRepo.getReferenceById(locationId);
        LocationEvent locationEvent = locationEventMapper.daoToDto(location, locationEventDao);
        locationEventRepo.save(locationEvent);
    }

    public void update(Long locationId, LocalDateTime date, LocationEventDao locationEventDao) {
        Location location = locationRepo.getReferenceById(locationId);
        LocationEvent locationEvent = locationEventRepo.getReferenceById(new LocationEventPk(location, convertLocalDateTimeToDate(date)));
        locationEvent.setName(locationEventDao.getName());
        locationEvent.setDescription(locationEventDao.getDescription());
        locationEvent.setCreateBy(locationEventDao.getCreateBy());
        locationEventRepo.save(locationEvent);
    }

    public void delete(Long locationId, LocalDateTime date, LocationEventDao locationEventDao) {
        Location location = locationRepo.getReferenceById(locationId);
        locationEventRepo.deleteById(new LocationEventPk(location, convertLocalDateTimeToDate(date)));
    }

    public List<LocationEvent> getAllByLocation(Long locationId) {
        Location location = locationRepo.getReferenceById(locationId);
        return locationEventRepo.findByIdLocation(location);
    }
}

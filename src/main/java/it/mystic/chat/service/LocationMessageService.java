package it.mystic.chat.service;

import it.mystic.chat.mapper.LocationMessageMapper;
import it.mystic.chat.model.dao.LocationMessageDao;
import it.mystic.chat.model.dto.Location;
import it.mystic.chat.model.dto.LocationMessage;
import it.mystic.chat.model.enums.MessageType;
import it.mystic.chat.repo.LocationMessageRepo;
import it.mystic.chat.repo.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static it.mystic.chat.util.DateUtil.convertLocalDateTimeToDate;
import static it.mystic.chat.util.DateUtil.subtractHours;

@Service
public class LocationMessageService {
    @Autowired
    private LocationMessageRepo locationMessageRepo;
    @Autowired
    private LocationRepo locationRepo;

    @Autowired
    private LocationMessageMapper locationMessageMapper;

    public void send(LocationMessageDao locationMessageDao) {
        Location location = locationRepo.getReferenceById(locationMessageDao.getLocationId());
        LocationMessage locationMessage = locationMessageMapper.daoToDto(location, MessageType.Standard, locationMessageDao);
        locationMessageRepo.save(locationMessage);
    }

    public void sendMaster(LocationMessageDao locationMessageDao) {
        Location location = locationRepo.getReferenceById(locationMessageDao.getLocationId());
        LocationMessage locationMessage = locationMessageMapper.daoToDto(location, MessageType.Master, locationMessageDao);
        locationMessageRepo.save(locationMessage);
    }

    public void sendAction(LocationMessageDao locationMessageDao) {
        Location location = locationRepo.getReferenceById(locationMessageDao.getLocationId());
        LocationMessage locationMessage = locationMessageMapper.daoToDto(location, MessageType.Azione, locationMessageDao);
        locationMessageRepo.save(locationMessage);
    }

    public void sendSystem(LocationMessageDao locationMessageDao) {
        Location location = locationRepo.getReferenceById(locationMessageDao.getLocationId());
        locationMessageDao.setSender("Sistema");
        LocationMessage locationMessage = locationMessageMapper.daoToDto(location, MessageType.Sistema, locationMessageDao);
        locationMessageRepo.save(locationMessage);
    }

    public List<LocationMessage> readChat(Long locationId) {
        Date endDate = new Date();
        Date startDate = subtractHours(endDate, 3);
        return locationMessageRepo.findByIdDataBetween(startDate,endDate).stream().filter(locationMessage -> {
           return locationMessage.getId().getLocation().getLocationId() == locationId;
        }).toList();
    }

    public List<LocationMessage> readChatBetween(Long locationId, LocalDateTime startDate, LocalDateTime endDate) {

        return locationMessageRepo.findByIdDataBetween(convertLocalDateTimeToDate(startDate), convertLocalDateTimeToDate(endDate)).stream()
                .filter(locationMessage -> {
            return locationMessage.getId().getLocation().getLocationId() == locationId;
        }).toList();
    }
}

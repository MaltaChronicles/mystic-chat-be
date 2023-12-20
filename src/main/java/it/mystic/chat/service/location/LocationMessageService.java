package it.mystic.chat.service.location;

import it.mystic.chat.mapper.LocationMapper;
import it.mystic.chat.model.dao.location.LocationMessageDao;
import it.mystic.chat.model.dto.location.Location;
import it.mystic.chat.model.dto.location.LocationMessage;
import it.mystic.chat.model.enums.MessageType;
import it.mystic.chat.model.response.location.LocationMessageResponse;
import it.mystic.chat.repo.location.LocationMessageRepo;
import it.mystic.chat.repo.location.LocationRepo;
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
    private LocationMapper locationMapper;

    public void send(LocationMessageDao locationMessageDao) {
        Location location = locationRepo.getReferenceById(locationMessageDao.getLocationId());
        LocationMessage locationMessage = locationMapper.messageDaoToDto(location, MessageType.Standard, locationMessageDao);
        locationMessageRepo.save(locationMessage);
    }

    public void sendMaster(LocationMessageDao locationMessageDao) {
        Location location = locationRepo.getReferenceById(locationMessageDao.getLocationId());
        LocationMessage locationMessage = locationMapper.messageDaoToDto(location, MessageType.Master, locationMessageDao);
        locationMessageRepo.save(locationMessage);
    }

    public void sendAction(LocationMessageDao locationMessageDao) {
        Location location = locationRepo.getReferenceById(locationMessageDao.getLocationId());
        LocationMessage locationMessage = locationMapper.messageDaoToDto(location, MessageType.Azione, locationMessageDao);
        locationMessageRepo.save(locationMessage);
    }

    public void sendSystem(LocationMessageDao locationMessageDao) {
        Location location = locationRepo.getReferenceById(locationMessageDao.getLocationId());
        locationMessageDao.setSender("Sistema");
        LocationMessage locationMessage = locationMapper.messageDaoToDto(location, MessageType.Sistema, locationMessageDao);
        locationMessageRepo.save(locationMessage);
    }

    public List<LocationMessageResponse> readChat(Long locationId) {
        Date endDate = new Date();
        Date startDate = subtractHours(endDate, 3);
        return locationMapper.messageDtoToResponse(locationId, locationMessageRepo.findByIdDataBetween(startDate, endDate));

    }

    public List<LocationMessageResponse> readChatBetween(Long locationId, LocalDateTime startDate, LocalDateTime endDate) {
        return locationMapper.messageDtoToResponse(
                locationId,
                locationMessageRepo.findByIdDataBetween(convertLocalDateTimeToDate(startDate), convertLocalDateTimeToDate(endDate))
        );
    }
}

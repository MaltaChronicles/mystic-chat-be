package it.mystic.chat.service.location;

import it.mystic.chat.mapper.LocationMapper;
import it.mystic.chat.model.dao.location.LocationDao;
import it.mystic.chat.model.dto.location.Location;
import it.mystic.chat.model.response.location.LocationResponse;
import it.mystic.chat.repo.location.LocationRepo;
import it.mystic.chat.util.MultipartFileConverter;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class LocationService {
    @Autowired
    private LocationRepo locationRepo;

    @Autowired
    private LocationMapper locationMapper;
    @Autowired
    private MultipartFileConverter converter;

    public LocationResponse create(LocationDao locationDao) {
        Location location = locationMapper.daoToDto(locationDao);
        return locationMapper.dtoToResponse(locationRepo.save(location));
    }

    public void update(Long locationId, LocationDao locationDao) {
        Location location = locationRepo.getReferenceById(locationId);
        location.setName(locationDao.getName());
        location.setDescription(locationDao.getDescription());
        locationRepo.save(location);
    }

    @SuppressWarnings("ConstantConditions")
    public void uploadImage(Long locationId, MultipartFile file) throws IOException {
        Location location = locationRepo.getReferenceById(locationId);
        Hibernate.initialize(location);
        if (location != null) {
            location.setImageUrl(converter.saveMultipartFile(file, "location/icon", locationId, "jpeg"));
            locationRepo.save(location);
        }
    }

    @SuppressWarnings("ConstantConditions")
    public void uploadBackgroundImage(Long locationId, MultipartFile file) throws IOException {
        Location location = locationRepo.getReferenceById(locationId);
        Hibernate.initialize(location);
        if (location != null) {
            location.setImageUrl(converter.saveMultipartFile(file, "location/background", locationId, "jpeg"));
            locationRepo.save(location);
        }
    }

    @SuppressWarnings("ConstantConditions")
    public void uploadAmbientMusic(Long locationId, MultipartFile file) throws IOException {
        Location location = locationRepo.getReferenceById(locationId);
        Hibernate.initialize(location);
        if (location != null) {
            location.setImageUrl(converter.saveMultipartFile(file, "location", locationId, "mp3"));
            locationRepo.save(location);
        }
    }

    public LocationResponse getById(Long locationId) {
        return locationMapper.dtoToResponse(locationRepo.getReferenceById(locationId));
    }

    public void delete(Long locationId) {
        locationRepo.deleteById(locationId);
    }
}

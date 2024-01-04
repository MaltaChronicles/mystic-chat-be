package it.mystic.chat.service.location;

import it.mystic.chat.mapper.LocationMapper;
import it.mystic.chat.model.dao.location.LocationPosterDao;
import it.mystic.chat.model.dto.character.Character;
import it.mystic.chat.model.dto.location.Location;
import it.mystic.chat.model.dto.location.LocationPoster;
import it.mystic.chat.model.dto.pk.LocationPosterPk;
import it.mystic.chat.model.response.location.LocationPosterResponse;
import it.mystic.chat.repo.character.CharacterRepo;
import it.mystic.chat.repo.location.LocationPosterRepo;
import it.mystic.chat.repo.location.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocationPosterService {
    @Autowired
    private LocationPosterRepo locationPosterRepo;
    @Autowired
    private CharacterRepo characterRepo;
    @Autowired
    private LocationRepo locationRepo;

    @Autowired
    private LocationMapper locationMapper;

    public LocationPosterResponse create(Long characterId, Long locationId, LocationPosterDao locationPosterDao) {
        Character character = characterRepo.getReferenceById(characterId);
        Location location = locationRepo.getReferenceById(locationId);
        LocationPoster locationPoster = locationMapper.locationDaoToDto(character, location, locationPosterDao);
        return locationMapper.locationDtoToResponse(locationPosterRepo.save(locationPoster));
    }

    public LocationPosterResponse getById(Long characterId, Long locationId, UUID uuid) {
        Character character = characterRepo.getReferenceById(characterId);
        Location location = locationRepo.getReferenceById(locationId);
        return locationMapper.locationDtoToResponse(locationPosterRepo.getReferenceById(new LocationPosterPk(uuid.toString(), character, location)));
    }

    public List<LocationPosterResponse> getByLocation(Long locationId) {
        Location location = locationRepo.getReferenceById(locationId);
        return locationMapper.locationDtoListToResponseList(locationPosterRepo.getByIdLocation(location));
    }

    public void delete(Long locationId, Long characterId, UUID uuid) {
        Character character = characterRepo.getReferenceById(characterId);
        Location location = locationRepo.getReferenceById(locationId);
        locationPosterRepo.deleteById(new LocationPosterPk(uuid.toString(), character, location));
    }

    public void changeIsPin(Long locationId, Long characterId, UUID uuid) {
        Character character = characterRepo.getReferenceById(characterId);
        Location location = locationRepo.getReferenceById(locationId);
        LocationPoster locationPoster = locationPosterRepo.getReferenceById(new LocationPosterPk(uuid.toString(), character, location));
        locationPoster.setIsPin(!locationPoster.getIsPin());
        locationPosterRepo.save(locationPoster);
    }
}

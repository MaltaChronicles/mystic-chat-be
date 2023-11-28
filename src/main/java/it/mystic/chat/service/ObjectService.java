package it.mystic.chat.service;

import it.mystic.chat.mapper.ObjectMapper;
import it.mystic.chat.model.dao.ObjectDao;
import it.mystic.chat.model.dto.ObjectDto;
import it.mystic.chat.model.enums.ObjectRank;
import it.mystic.chat.model.enums.ObjectType;
import it.mystic.chat.repo.ObjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjectService {
    @Autowired
    private ObjectRepo objectRepo;

    @Autowired
    private ObjectMapper objectMapper;

    public ObjectDto create(ObjectDao objectDao) {
        ObjectDto objectDto = objectMapper.daoToDto(objectDao);
        return objectRepo.save(objectDto);
    }

    public void update(ObjectDao objectDao) {
        ObjectDto objectDto = objectMapper.daoToDto(objectDao);
        objectRepo.save(objectDto);
    }

    public void deleteById(Long objectId) {
        objectRepo.deleteById(objectId);
    }

    public ObjectDto getById(Long objectId) {
        return objectRepo.getReferenceById(objectId);
    }

    public List<ObjectDto> getMarketByType(ObjectType objectType) {
        return objectRepo.getAllByType(objectType).stream().filter(object -> {
            Boolean rank = object.getRank().equals(ObjectRank.D) || object.getRank().equals(ObjectRank.C) || object.getRank().equals(ObjectRank.B);
            Boolean notUnique = !object.getIsUnique();
            return rank && notUnique;
        }).collect(Collectors.toList());
    }
}

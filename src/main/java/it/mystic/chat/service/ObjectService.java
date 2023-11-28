package it.mystic.chat.service;

import it.mystic.chat.mapper.ObjectMapper;
import it.mystic.chat.model.dao.ObjectDao;
import it.mystic.chat.model.dto.ObjectDto;
import it.mystic.chat.repo.ObjectRepo;
import it.mystic.chat.util.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

package it.mystic.chat.service;

import it.mystic.chat.mapper.ObjectMapper;
import it.mystic.chat.model.dao.ObjectDao;
import it.mystic.chat.model.dto.Object;
import it.mystic.chat.model.enums.ObjectRank;
import it.mystic.chat.model.enums.ObjectType;
import it.mystic.chat.repo.ObjectRepo;
import it.mystic.chat.util.MultipartFileConverter;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjectService {
    @Autowired
    private ObjectRepo objectRepo;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MultipartFileConverter converter;

    public Object create(ObjectDao objectDao) {
        Object object = objectMapper.daoTo(objectDao);
        return objectRepo.save(object);
    }

    public void update(ObjectDao objectDao) throws IOException {
        Object object = objectMapper.daoTo(objectDao);
        objectRepo.save(object);
    }

    public void deleteById(Long objectId) {
        objectRepo.deleteById(objectId);
    }

    public Object getById(Long objectId) {
        return objectRepo.getReferenceById(objectId);
    }

    public List<Object> getMarketByType(ObjectType objectType) {
        return objectRepo.getAllByType(objectType).stream().filter(object -> {
            Boolean rank = object.getRank().equals(ObjectRank.D) || object.getRank().equals(ObjectRank.C) || object.getRank().equals(ObjectRank.B);
            Boolean notUnique = !object.getIsUnique();
            return rank && notUnique;
        }).collect(Collectors.toList());
    }

    @SuppressWarnings("ConstantConditions")
    public void uploadImage(Long objectId, MultipartFile file) throws IOException {
        Object object = objectRepo.getReferenceById(objectId);
        Hibernate.initialize(object);
        if (object != null) {
            object.setImageUrl(converter.saveMultipartFile(file, "object", objectId));
            objectRepo.save(object);
        }
    }
}

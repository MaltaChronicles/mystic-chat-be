package it.mystic.chat.service;

import it.mystic.chat.mapper.AbilityMapper;
import it.mystic.chat.model.dao.AbilityDao;
import it.mystic.chat.model.dto.Ability;
import it.mystic.chat.model.enums.Class;
import it.mystic.chat.model.response.AbilityResponse;
import it.mystic.chat.repo.AbilityRepo;
import it.mystic.chat.util.MultipartFileConverter;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class AbilityService {
    @Autowired
    private AbilityRepo abilityRepo;
    @Autowired
    private AbilityMapper abilityMapper;
    @Autowired
    private MultipartFileConverter converter;

    public AbilityResponse create(AbilityDao abilityDao) {
        Ability ability = abilityMapper.daoToDto(abilityDao);
        ability.setActionLink("system/useAbility/" + ability.getAbilityId());
        return abilityMapper.dtoToResponse(abilityRepo.save(ability));
    }

    public void update(Long abilityId, AbilityDao abilityDao) {
        Ability ability = abilityRepo.getReferenceById(abilityId);
        ability.setName(abilityDao.getName());
        ability.setAbilityClass(abilityDao.getAbilityClass());
        ability.setType(abilityDao.getType());
        ability.setDescription(abilityDao.getDescription());
        ability.setDuration(abilityDao.getDuration());
        ability.setTargetType(abilityDao.getTargetType());
        ability.setMaxTargetNumber(abilityDao.getMaxTargetNumber());
        ability.setMaxLevel(abilityDao.getMaxLevel());
        ability.setManaPriceForTarget(abilityDao.getManaPriceForTarget());
        ability.setHpPriceForTarget(abilityDao.getHpPriceForTarget());
        abilityRepo.save(ability);
    }

    @SuppressWarnings("ConstantConditions")
    public void uploadImage(Long abilityId, MultipartFile file) throws IOException {
        Ability ability = abilityRepo.getReferenceById(abilityId);
        Hibernate.initialize(ability);
        if (ability != null) {
            ability.setImageUrl(converter.saveMultipartFile(file, "ability", abilityId, "jpeg"));
            abilityRepo.save(ability);
        }
    }

    public AbilityResponse getById(Long abilityId) {
        return abilityMapper.dtoToResponse(abilityRepo.getReferenceById(abilityId));
    }

    public void delete(Long abilityId) {
        abilityRepo.deleteById(abilityId);
    }

    public List<AbilityResponse> getByClass(Class abilityClass) {
        return abilityRepo.getReferenceByAbilityClass(abilityClass).stream()
                .map(ability -> {
                    return abilityMapper.dtoToResponse(ability);
                }).toList();
    }
}

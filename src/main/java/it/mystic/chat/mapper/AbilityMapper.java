package it.mystic.chat.mapper;

import it.mystic.chat.model.dao.AbilityDao;
import it.mystic.chat.model.dto.Ability;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AbilityMapper {
    @Value("${upload.dir}")
    private String uploadDir;

    public Ability daoToDto(AbilityDao abilityDao) {
        return new Ability(
                null,
                abilityDao.getName(),
                uploadDir + "img/ability/default.jpeg",
                abilityDao.getAbilityClass(),
                abilityDao.getType(),
                abilityDao.getDescription(),
                abilityDao.getDuration(),
                abilityDao.getTargetType(),
                abilityDao.getMaxTargetNumber(),
                abilityDao.getMaxLevel(),
                abilityDao.getManaPriceForTarget(),
                abilityDao.getHpPriceForTarget(),
                null
        );
    }
}

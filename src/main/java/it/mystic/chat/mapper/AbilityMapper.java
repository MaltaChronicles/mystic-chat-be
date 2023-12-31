package it.mystic.chat.mapper;

import it.mystic.chat.model.dao.AbilityDao;
import it.mystic.chat.model.dto.Ability;
import it.mystic.chat.model.response.AbilityResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AbilityMapper {
    @Value("${upload.dir}")
    private String uploadDir;

    public Ability daoToDto(AbilityDao abilityDao) {
        if (Objects.isNull(abilityDao))
            return null;
        return new Ability(
                null,
                abilityDao.name(),
                uploadDir + "img/ability/default.jpeg",
                abilityDao.abilityClass(),
                abilityDao.type(),
                abilityDao.description(),
                abilityDao.duration(),
                abilityDao.targetType(),
                abilityDao.maxTargetNumber(),
                abilityDao.maxTargetNumber(),
                abilityDao.manaPriceForTarget(),
                abilityDao.hpPriceForTarget(),
                null,
                null
        );
    }

    public AbilityResponse dtoToResponse(Ability ability) {
        if (Objects.isNull(ability))
            return null;
        return new AbilityResponse(
                ability.getAbilityId(),
                ability.getName(),
                ability.getImageUrl(),
                ability.getAbilityClass(),
                ability.getType(),
                ability.getDescription(),
                ability.getDuration(),
                ability.getTargetType(),
                ability.getMaxTargetNumber(),
                ability.getMaxLevel(),
                ability.getManaPriceForTarget(),
                ability.getHpPriceForTarget(),
                ability.getActionLink()
        );
    }
}

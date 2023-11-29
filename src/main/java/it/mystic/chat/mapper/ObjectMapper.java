package it.mystic.chat.mapper;

import it.mystic.chat.model.dao.ObjectDao;
import it.mystic.chat.model.dto.Object;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapper {

    public Object daoTo(ObjectDao objectDao){
        return new Object(
                objectDao.getObjectId(),
                objectDao.getName(),
                objectDao.getImgUrl(),
                objectDao.getType(),
                objectDao.getDescription(),
                objectDao.getRank(),
                objectDao.getIsMartial(),
                objectDao.getRangeType(),
                objectDao.getPrice(),

                objectDao.getFeaturePrecisionOne(),
                objectDao.getFeaturePrecisionTwo(),
                objectDao.getDamage(),
                objectDao.getDamageType(),

                objectDao.getDefenseModifier(),
                objectDao.getResistanceModifier(),
                objectDao.getInitiativeModifier(),

                objectDao.getLifeModifier(),
                objectDao.getManaModifier(),

                objectDao.getDexterityModifier(),
                objectDao.getInsightModifier(),
                objectDao.getVigorModifier(),
                objectDao.getWillModifier(),

                objectDao.getPhysicalModifier(),
                objectDao.getWaterModifier(),
                objectDao.getEarthModifier(),
                objectDao.getFireModifier(),
                objectDao.getAirModifier(),
                objectDao.getElectricityModifier(),
                objectDao.getIceModifier(),
                objectDao.getLightModifier(),
                objectDao.getDarkModifier(),
                objectDao.getPoisonModifier(),

                objectDao.getIsUnique(),
                null
        );
    }
}

package it.mystic.chat.mapper;

import it.mystic.chat.model.dao.ObjectDao;
import it.mystic.chat.model.dto.Object;
import it.mystic.chat.model.response.ObjectResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ObjectMapper {

    @Value("${upload.dir}")
    private String uploadDir;

    public Object daoToDto(ObjectDao objectDao) {
        if (Objects.isNull(objectDao))
            return null;
        return new Object(
                null,
                objectDao.name(),
                uploadDir + "img/object/default.jpeg",
                objectDao.type(),
                objectDao.description(),
                objectDao.rank(),
                objectDao.isMartial(),
                objectDao.rangeType(),
                objectDao.price(),

                objectDao.featurePrecisionOne(),
                objectDao.featurePrecisionTwo(),
                objectDao.damage(),
                objectDao.damageType(),

                objectDao.defenseModifier(),
                objectDao.resistanceModifier(),
                objectDao.initiativeModifier(),

                objectDao.lifeModifier(),
                objectDao.manaModifier(),

                objectDao.dexterityModifier(),
                objectDao.insightModifier(),
                objectDao.vigorModifier(),
                objectDao.willModifier(),

                objectDao.physicalModifier(),
                objectDao.waterModifier(),
                objectDao.earthModifier(),
                objectDao.fireModifier(),
                objectDao.airModifier(),
                objectDao.electricityModifier(),
                objectDao.iceModifier(),
                objectDao.lightModifier(),
                objectDao.darkModifier(),
                objectDao.poisonModifier(),

                objectDao.isUnique(),
                null
        );
    }

    public ObjectResponse dtoToResponse(Object object) {
        if (Objects.isNull(object))
            return null;
        return new ObjectResponse(
                object.getObjectId(),
                object.getName(),
                object.getImageUrl(),
                object.getType(),
                object.getDescription(),
                object.getRank(),
                object.getIsMartial(),
                object.getRangeType(),
                object.getPrice(),

                object.getFeaturePrecisionOne(),
                object.getFeaturePrecisionTwo(),
                object.getDamage(),
                object.getDamageType(),

                object.getDefenseModifier(),
                object.getResistanceModifier(),
                object.getInitiativeModifier(),

                object.getLifeModifier(),
                object.getManaModifier(),

                object.getDexterityModifier(),
                object.getInsightModifier(),
                object.getVigorModifier(),
                object.getWillModifier(),

                object.getPhysicalModifier(),
                object.getWaterModifier(),
                object.getEarthModifier(),
                object.getFireModifier(),
                object.getAirModifier(),
                object.getElectricityModifier(),
                object.getIceModifier(),
                object.getLightModifier(),
                object.getDarkModifier(),
                object.getPoisonModifier(),

                object.getIsUnique()
        );
    }
}

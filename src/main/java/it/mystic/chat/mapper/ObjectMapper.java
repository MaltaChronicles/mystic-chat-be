package it.mystic.chat.mapper;

import it.mystic.chat.model.dao.ObjectDao;
import it.mystic.chat.model.dto.Object;
import it.mystic.chat.util.MultipartFileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class ObjectMapper {

    public Object daoTo(ObjectDao objectDao) {
        return new Object(
                objectDao.getObjectId(),
                objectDao.getName(),
                "uploads/object/default.jpeg",
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

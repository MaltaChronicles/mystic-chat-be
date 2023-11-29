package it.mystic.chat.mapper;


import it.mystic.chat.model.dao.CharacterDao;
import it.mystic.chat.model.dao.CharacterDescriptionDao;
import it.mystic.chat.model.dto.CharacterDescription;
import it.mystic.chat.model.dto.Character;
import org.springframework.stereotype.Component;


@Component
public class CharacterMapper {

    public Character daoTo(CharacterDao characterDao) {
        return new Character(
                characterDao.getName(),
                characterDao.getIdentity(),
                characterDao.getOrigin(),
                characterDao.getTheme(),
                characterDao.getJob(),
                characterDao.getRace()
        );
    }

    public CharacterDescription descriptionDaoToDescription(CharacterDescriptionDao characterDescriptionDao, Character character) {
        return new CharacterDescription(
                characterDescriptionDao.getRightEye(),
                characterDescriptionDao.getLeftEye(),
                characterDescriptionDao.getHair(),
                characterDescriptionDao.getHeight(),
                characterDescriptionDao.getWeight(),
                characterDescriptionDao.getAge(),
                characterDescriptionDao.getGender(),
                "uploads/object/default.jpeg",
                character
        );
    }
}

package it.mystic.chat.mapper;


import it.mystic.chat.model.dao.CharacterDao;
import it.mystic.chat.model.dao.CharacterDescriptionDao;
import it.mystic.chat.model.dto.CharacterDescriptionDto;
import it.mystic.chat.model.dto.CharacterDto;
import org.springframework.stereotype.Component;


@Component
public class CharacterMapper {

    public CharacterDto daoToDto(CharacterDao characterDao) {
        return new CharacterDto(
                characterDao.getName(),
                characterDao.getIdentity(),
                characterDao.getOrigin(),
                characterDao.getTheme(),
                characterDao.getJob(),
                characterDao.getRace()
        );
    }

    public CharacterDescriptionDto descriptionDaoToDescriptionDto(CharacterDescriptionDao characterDescriptionDao, CharacterDto characterDto) {
        return new CharacterDescriptionDto(
                characterDescriptionDao.getRightEye(),
                characterDescriptionDao.getLeftEye(),
                characterDescriptionDao.getHair(),
                characterDescriptionDao.getHeight(),
                characterDescriptionDao.getWeight(),
                characterDescriptionDao.getAge(),
                characterDescriptionDao.getGender(),
                characterDto
        );
    }
}

package it.mystic.chat.mapper;


import it.mystic.chat.model.dao.CharacterDao;
import it.mystic.chat.model.dto.CharacterDto;
import org.springframework.stereotype.Component;


@Component
public class CharacterMapper {

    public CharacterDto daoToDto(CharacterDao characterDao) {
        CharacterDto characterDto = new CharacterDto(
                characterDao.getName(),
                characterDao.getIdentity(),
                characterDao.getOrigin(),
                characterDao.getTheme(),
                characterDao.getJob()
        );
        return characterDto;
    }

}

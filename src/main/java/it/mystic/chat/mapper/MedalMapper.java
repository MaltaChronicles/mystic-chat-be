package it.mystic.chat.mapper;

import it.mystic.chat.model.dao.ObjectDao;
import it.mystic.chat.model.dto.Medal;
import it.mystic.chat.model.dto.Object;
import it.mystic.chat.model.response.MedalResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedalMapper {

    @Value("${upload.dir}")
    private String uploadDir;

    public Medal daoTo(String name) {
        return new Medal(
                null,
                name,
                uploadDir + "img/medal/default.jpeg",
                null
        );
    }

    public MedalResponse medalToMedalResponse(Medal medal) {
        return new MedalResponse(
                medal.getName(),
                medal.getImageUrl()
        );
    }

    public List<MedalResponse> medalListToMedalResponseList(List<Medal> medalList) {
        return medalList.stream().map(medal -> {
          return new MedalResponse(medal.getName(), medal.getImageUrl())  ;
        }).toList();
    }
}

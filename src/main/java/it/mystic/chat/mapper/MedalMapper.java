package it.mystic.chat.mapper;

import it.mystic.chat.model.dto.Medal;
import it.mystic.chat.model.response.MedalResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class MedalMapper {

    @Value("${upload.dir}")
    private String uploadDir;

    public Medal daoTo(String name) {
        if (Objects.isNull(name))
            return null;
        return new Medal(
                null,
                name,
                uploadDir + "img/medal/default.jpeg",
                null
        );
    }

    public MedalResponse dtoToResponse(Medal medal) {
        if (Objects.isNull(medal))
            return null;
        return new MedalResponse(
                medal.getName(),
                medal.getImageUrl()
        );
    }

    public List<MedalResponse> medalListToResponseList(List<Medal> medalList) {
        if (Objects.isNull(medalList))
            return null;
        return medalList.stream().map(medal -> {
            return new MedalResponse(medal.getName(), medal.getImageUrl());
        }).toList();
    }
}

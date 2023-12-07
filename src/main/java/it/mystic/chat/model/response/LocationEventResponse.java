package it.mystic.chat.model.response;

import java.util.Date;


public record LocationEventResponse(
        Date data,
        String name,
        String description,
        String createBy
) {
}

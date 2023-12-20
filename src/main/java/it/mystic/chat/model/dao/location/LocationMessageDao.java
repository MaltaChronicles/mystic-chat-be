package it.mystic.chat.model.dao.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationMessageDao {
    Long locationId;
    String sender;
    String tag;
    String body;
    String imageLink;
}

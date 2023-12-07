package it.mystic.chat.model.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationEventResponse {
    Date data;
    String name;
    String description;
    String createBy;
}

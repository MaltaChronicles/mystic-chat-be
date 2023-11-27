package it.mystic.chat.model.dao;

import it.mystic.chat.model.enums.*;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CharacterDescriptionDao {

    Color rightEye;
    Color leftEye;
    Color hair;
    Double height;
    Double weight;
    Integer age;
    Gender gender;
}

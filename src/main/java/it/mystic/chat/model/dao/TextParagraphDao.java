package it.mystic.chat.model.dao;

import it.mystic.chat.model.dto.Text;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record TextParagraphDao (
    String title,
    String body

){}

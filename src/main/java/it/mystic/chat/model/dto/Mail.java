package it.mystic.chat.model.dto;

import it.mystic.chat.model.dto.pk.MailPk;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Mail {
    @EmbeddedId
    MailPk id;

    @Column(length = 65000)
    String body;

    @Column
    Boolean isRead;
}

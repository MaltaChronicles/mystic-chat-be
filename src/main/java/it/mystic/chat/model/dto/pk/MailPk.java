package it.mystic.chat.model.dto.pk;

import it.mystic.chat.model.dto.character.Character;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailPk implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id")
    Character sender;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id")
    Character recipient;
    @Column(updatable = false)
    Date date;
}

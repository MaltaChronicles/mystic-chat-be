package it.mystic.chat.security.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IpPk {
    @Column(updatable = false)
    String username;

    @Column(updatable = false)
    Integer Ip;
}

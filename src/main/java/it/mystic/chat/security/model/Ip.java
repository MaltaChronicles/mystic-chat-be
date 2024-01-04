package it.mystic.chat.security.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "security_ip")
public class Ip {
    @EmbeddedId
    IpPk id;

    @Column(nullable = false)
    Boolean isBan;
}

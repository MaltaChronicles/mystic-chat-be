package it.mystic.chat.security;

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
@Table(name = "config_ip")
public class IpDto {
    @EmbeddedId
    IpPk id;

    Boolean isBan;

    public IpDto(IpPk id) {
        this.id = id;
        isBan = false;
    }
}

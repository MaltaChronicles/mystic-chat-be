package it.mystic.chat.security;

import jakarta.persistence.*;
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

    public  IpDto(IpPk id){
        this.id = id;
        isBan = false;
    }
}

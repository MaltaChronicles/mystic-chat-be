package it.mystic.chat.mapper;

import it.mystic.chat.model.dto.Configuration;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ConfigurationMapper {
    public Map<String, String> listToMap(List<Configuration> configurationList) {
        return configurationList.stream().collect(Collectors.toMap(Configuration::getName, Configuration::getValue));
    }
}

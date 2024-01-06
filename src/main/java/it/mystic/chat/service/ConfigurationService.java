package it.mystic.chat.service;

import it.mystic.chat.mapper.ConfigurationMapper;
import it.mystic.chat.model.dto.Configuration;
import it.mystic.chat.repo.ConfigurationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ConfigurationService {

    @Autowired
    private ConfigurationRepo configurationRepo;

    @Autowired
    private ConfigurationMapper configurationMapper;

    public Map<String, String> getAll() {
        List<Configuration> configurationList = configurationRepo.findAll();
        return configurationMapper.listToMap(configurationList);
    }

    public String getValueByName(String name) {
        Configuration configuration = configurationRepo.getReferenceById(name);
        return configuration.getValue();
    }
}

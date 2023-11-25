package it.mystic.chat.service;

import it.mystic.chat.model.enums.*;
import it.mystic.chat.model.enums.Class;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EnumService {
    public List<String> getClasses() {
        return Arrays.stream(Class.values()).map(item -> {
            return item.toString().replace("_","");
        }).toList();
    }

    public List<String> getColors() {
        return Arrays.stream(Color.values()).map(item -> {
            return item.toString().replace("_","");
        }).toList();
    }

    public List<String> getOrigins() {
        return Arrays.stream(Origin.values()).map(item -> {
            return item.toString().replace("_","");
        }).toList();
    }

    public List<String> getThemes() {
        return Arrays.stream(Theme.values()).map(item -> {
            return item.toString().replace("_","");
        }).toList();
    }

    public List<String> getObjectTypes() {
        return Arrays.stream(ObjectType.values()).map(item -> {
            return item.toString().replace("_","");
        }).toList();
    }

    public List<String> getDiceValues() {
        return Arrays.stream(DiceValue.values()).map(item -> {
            return item.toString().replace("_","");
        }).toList();
    }

    public List<String> getFeatures() {
        return Arrays.stream(Feature.values()).map(item -> {
            return item.toString().replace("_","");
        }).toList();
    }

    public List<String> getObjectRanks() {
        return Arrays.stream(ObjectRank.values()).map(item -> {
            return item.toString().replace("_","");
        }).toList();
    }
}

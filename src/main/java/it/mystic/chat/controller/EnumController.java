package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.enums.Class;
import it.mystic.chat.model.enums.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/config/enum")
@Tag(name = "ENUM")
public class EnumController {

    @GetMapping("/getClasses")
    public ResponseEntity<List<Class>> getClasses() {
        return ResponseEntity.ok(Arrays.stream(Class.values()).toList());
    }

    @GetMapping("/getColors")
    public ResponseEntity<List<Color>> getColors() {
        return ResponseEntity.ok(Arrays.stream(Color.values()).toList());
    }

    @GetMapping("/getOrigins")
    public ResponseEntity<List<Origin>> getOrigins() {
        return ResponseEntity.ok(Arrays.stream(Origin.values()).toList());
    }

    @GetMapping("/getThemes")
    public ResponseEntity<List<Theme>> getThemes() {
        return ResponseEntity.ok(Arrays.stream(Theme.values()).toList());
    }

    @GetMapping("/getObjectTypes")
    public ResponseEntity<List<ObjectType>> getObjectTypes() {
        return ResponseEntity.ok(Arrays.stream(ObjectType.values()).toList());
    }

    @GetMapping("/getObjectRanks")
    public ResponseEntity<List<ObjectRank>> getObjectRanks() {
        return ResponseEntity.ok(Arrays.stream(ObjectRank.values()).toList());
    }

    @GetMapping("/getDiceValues")
    public ResponseEntity<List<DiceValue>> getDiceValues() {
        return ResponseEntity.ok(Arrays.stream(DiceValue.values()).toList());
    }

    @GetMapping("/getFeatures")
    public ResponseEntity<List<Feature>> getFeatures() {
        return ResponseEntity.ok(Arrays.stream(Feature.values()).toList());
    }

    @GetMapping("/getRoles")
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok(Arrays.stream(Role.values()).toList());
    }

    @GetMapping("/getJobs")
    public ResponseEntity<List<Job>> getJobs() {
        return ResponseEntity.ok(Arrays.stream(Job.values()).toList());
    }

    @GetMapping("/getStandardsOfLiving")
    public ResponseEntity<List<StandardOfLiving>> getStandardsOfLiving() {
        return ResponseEntity.ok(Arrays.stream(StandardOfLiving.values()).toList());
    }

    @GetMapping("/getAffinities")
    public ResponseEntity<List<Affinity>> getAffinities() {
        return ResponseEntity.ok(Arrays.stream(Affinity.values()).toList());
    }

    @GetMapping("/getRaces")
    public ResponseEntity<List<Race>> getRaces() {
        return ResponseEntity.ok(Arrays.stream(Race.values()).toList());
    }

    @GetMapping("/getRangeTypes")
    public ResponseEntity<List<RangeType>> getRangeTypes() {
        return ResponseEntity.ok(Arrays.stream(RangeType.values()).toList());
    }

    @GetMapping("/getAbilityTypes")
    public ResponseEntity<List<AbilityType>> getAbilityTypes() {
        return ResponseEntity.ok(Arrays.stream(AbilityType.values()).toList());
    }

    @GetMapping("/getDurationTypes")
    public ResponseEntity<List<DurationType>> getDurationTypes() {
        return ResponseEntity.ok(Arrays.stream(DurationType.values()).toList());
    }

    @GetMapping("/getGenders")
    public ResponseEntity<List<Gender>> getGenders() {
        return ResponseEntity.ok(Arrays.stream(Gender.values()).toList());
    }

    @GetMapping("/getMessageTypes")
    public ResponseEntity<List<MessageType>> getMessageTypes() {
        return ResponseEntity.ok(Arrays.stream(MessageType.values()).toList());
    }

    @GetMapping("/getTargetTypes")
    public ResponseEntity<List<TargetType>> getTargetTypes() {
        return ResponseEntity.ok(Arrays.stream(TargetType.values()).toList());
    }

    @GetMapping("/getGuildRank")
    public ResponseEntity<List<GuildRank>> getGuildRanks() {
        return ResponseEntity.ok(Arrays.stream(GuildRank.values()).toList());
    }

    @GetMapping("/getTextTypes")
    public ResponseEntity<List<TextType>> getTextTypes() {
        return ResponseEntity.ok(Arrays.stream(TextType.values()).toList());
    }

    @GetMapping("/getBoardTypes")
    public ResponseEntity<List<BoardType>> getBoardTypes() {
        return ResponseEntity.ok(Arrays.stream(BoardType.values()).toList());
    }
}

package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.exception.GenericException;
import it.mystic.chat.model.enums.Affinity;
import it.mystic.chat.model.enums.DiceValue;
import it.mystic.chat.service.CharacterStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/on/character/stats")
@Tag(name = "CHARACTER STATS")
public class CharacterStatsController {
    @Autowired
    private CharacterStatusService characterService;


    @PatchMapping("/sleep/{characterId}")
    public ResponseEntity<Void> sleep(@PathVariable Long characterId) {
        characterService.sleep(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualLife/{characterId}/{value}")
    public ResponseEntity<Void> updateActualLife(@PathVariable Long characterId, @PathVariable Integer value) {
        characterService.updateActualLife(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualMana/{characterId}/{value}")
    public ResponseEntity<Void> updateActualMana(@PathVariable Long characterId, @PathVariable Integer value) {
        characterService.updateActualMana(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/addExperience/{characterId}/{value}")
    public ResponseEntity<Void> addExperience(@PathVariable Long characterId, @PathVariable Integer value) throws GenericException {
        characterService.addExperience(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/subExperience/{characterId}/{value}")
    public ResponseEntity<Void> subExperience(@PathVariable Long characterId, @PathVariable Integer value) throws GenericException {
        characterService.subExperience(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/levelUp/{characterId}")
    public ResponseEntity<Void> levelUp(@PathVariable Long characterId) throws GenericException {
        characterService.levelUp(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualInitiative/{characterId}/{value}")
    public ResponseEntity<Void> updateActualInitiative(@PathVariable Long characterId, @PathVariable Integer value) {
        characterService.updateActualInitiative(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateCoin/{characterId}/{value}")
    public ResponseEntity<Void> updateCoin(@PathVariable Long characterId, @PathVariable Integer value) {
        characterService.updateCoin(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/upTotalDexterity/{characterId}")
    public ResponseEntity<Void> updateTotalDexterity(@PathVariable Long characterId) {
        characterService.upTotalDexterity(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualDexterity/{characterId}/{value}")
    public ResponseEntity<Void> updateActualDexterity(@PathVariable Long characterId, @PathVariable DiceValue value) {
        characterService.updateActualDexterity(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/upTotalInsight/{characterId}")
    public ResponseEntity<Void> updateTotalInsight(@PathVariable Long characterId) {
        characterService.upTotalInsight(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualInsight/{characterId}/{value}")
    public ResponseEntity<Void> updateActualInsight(@PathVariable Long characterId, @PathVariable DiceValue value) {
        characterService.updateActualInsight(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/upTotalVigor/{characterId}")
    public ResponseEntity<Void> updateTotalVigor(@PathVariable Long characterId) {
        characterService.upTotalVigor(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualVigor/{characterId}/{value}")
    public ResponseEntity<Void> updateActualVigor(@PathVariable Long characterId, @PathVariable DiceValue value) {
        characterService.updateActualVigor(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/upTotalWill/{characterId}")
    public ResponseEntity<Void> updateTotalWill(@PathVariable Long characterId) {
        characterService.upTotalWill(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualWill/{characterId}/{value}")
    public ResponseEntity<Void> updateActualWill(@PathVariable Long characterId, @PathVariable DiceValue value) {
        characterService.updateActualWill(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualDefense/{characterId}/{value}")
    public ResponseEntity<Void> updateActualDefense(@PathVariable Long characterId, @PathVariable Integer value) {
        characterService.updateActualDefense(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualResistance/{characterId}/{value}")
    public ResponseEntity<Void> updateActualResistance(@PathVariable Long characterId, @PathVariable Integer value) {
        characterService.updateActualResistance(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateMartialArmors/{characterId}/{value}")
    public ResponseEntity<Void> updateMartialArmors(@PathVariable Long characterId, @PathVariable Boolean value) {
        characterService.updateMartialArmors(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateMartialShield/{characterId}/{value}")
    public ResponseEntity<Void> updateMartialShield(@PathVariable Long characterId, @PathVariable Boolean value) {
        characterService.updateMartialShield(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateMartialMeleeWeapons/{characterId}/{value}")
    public ResponseEntity<Void> updateMartialMeleeWeapons(@PathVariable Long characterId, @PathVariable Boolean value) {
        characterService.updateMartialMeleeWeapons(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateMartialDistanceWeapons/{characterId}/{value}")
    public ResponseEntity<Void> updateMartialDistanceWeapons(@PathVariable Long characterId, @PathVariable Boolean value) {
        characterService.updateMartialDistanceWeapons(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualPhysicalAffinity/{characterId}/{value}")
    public ResponseEntity<Void> updateActualPhysicalAffinity(@PathVariable Long characterId, @PathVariable Affinity value) {
        characterService.updateActualPhysicalAffinity(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualWaterAffinity/{characterId}/{value}")
    public ResponseEntity<Void> updateActualWaterAffinity(@PathVariable Long characterId, @PathVariable Affinity value) {
        characterService.updateActualWaterAffinity(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualEarthAffinity/{characterId}/{value}")
    public ResponseEntity<Void> updateActualEarthAffinity(@PathVariable Long characterId, @PathVariable Affinity value) {
        characterService.updateActualEarthAffinity(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualFireAffinity/{characterId}/{value}")
    public ResponseEntity<Void> updateActualFireAffinity(@PathVariable Long characterId, @PathVariable Affinity value) {
        characterService.updateActualFireAffinity(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualAirAffinity/{characterId}/{value}")
    public ResponseEntity<Void> updateActualAirAffinity(@PathVariable Long characterId, @PathVariable Affinity value) {
        characterService.updateActualAirAffinity(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualElectricityAffinity/{characterId}/{value}")
    public ResponseEntity<Void> updateActualElectricityAffinity(@PathVariable Long characterId, @PathVariable Affinity value) {
        characterService.updateActualElectricityAffinity(characterId, value);
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/updateActualIceAffinity/{characterId}/{value}")
    public ResponseEntity<Void> updateActualIceAffinity(@PathVariable Long characterId, @PathVariable Affinity value) {
        characterService.updateActualIceAffinity(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualLightAffinity/{characterId}/{value}")
    public ResponseEntity<Void> updateActualLightAffinity(@PathVariable Long characterId, @PathVariable Affinity value) {
        characterService.updateActualLightAffinity(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualDarkAffinity/{characterId}/{value}")
    public ResponseEntity<Void> updateActualDarkAffinity(@PathVariable Long characterId, @PathVariable Affinity value) {
        characterService.updateActualDarkAffinity(characterId, value);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateActualPoisonAffinity/{characterId}/{value}")
    public ResponseEntity<Void> updateActualPoisonAffinity(@PathVariable Long characterId, @PathVariable Affinity value) {
        characterService.updateActualPoisonAffinity(characterId, value);
        return ResponseEntity.ok().build();
    }

}

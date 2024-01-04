package it.mystic.chat.util;

import it.mystic.chat.model.dto.character.CharacterStats;
import it.mystic.chat.model.enums.Affinity;
import it.mystic.chat.model.enums.DiceValue;
import it.mystic.chat.model.enums.Race;

public class CharacterStatsUtil {
    public static Integer obtainDiceValue(DiceValue dice) {
        return Integer.valueOf(dice.toString().replace("d", ""));
    }

    public static void levelUp(CharacterStats stats) {
        stats.setActualExperience(stats.getActualExperience() - 10);
        stats.setLevel(stats.getLevel() + 1);

        stats.setTotalLife(stats.getLevel() + (5 * obtainDiceValue(stats.getTotalVigor())));
        stats.setCrisis(stats.getTotalLife() / 2);

        stats.setTotalMana(stats.getLevel() + (5 * obtainDiceValue(stats.getTotalWill())));
    }

    public static void setRaceAffinity(CharacterStats stats, Race race) {
        stats.setPhysicalAffinity(Affinity.Nulla);
        stats.setWaterAffinity(Affinity.Nulla);
        stats.setEarthAffinity(Affinity.Nulla);
        stats.setFireAffinity(Affinity.Nulla);
        stats.setAirAffinity(Affinity.Nulla);
        stats.setElectricityAffinity(Affinity.Nulla);
        stats.setIceAffinity(Affinity.Nulla);
        stats.setLightAffinity(Affinity.Nulla);
        stats.setDarkAffinity(Affinity.Nulla);
        stats.setPoisonAffinity(Affinity.Nulla);

        switch (race) {
            case Elfica -> {
                stats.setAirAffinity(Affinity.Resistente);
                stats.setIceAffinity(Affinity.Debole);
            }
            case Nanica -> {
                stats.setEarthAffinity(Affinity.Resistente);
                stats.setWaterAffinity(Affinity.Debole);
            }
            case Orchesca -> {
                stats.setWaterAffinity(Affinity.Resistente);
                stats.setFireAffinity(Affinity.Debole);
            }
            case Draconica -> {
                stats.setFireAffinity(Affinity.Resistente);
                stats.setDarkAffinity(Affinity.Debole);
            }
            case Mannara -> {
                stats.setPoisonAffinity(Affinity.Resistente);
                stats.setFireAffinity(Affinity.Debole);
            }
            case Fatata -> {
                stats.setLightAffinity(Affinity.Resistente);
                stats.setPoisonAffinity(Affinity.Debole);
            }
            case Mezzogigante -> {
                stats.setIceAffinity(Affinity.Resistente);
                stats.setElectricityAffinity(Affinity.Debole);
            }
            case Infernale -> {
                stats.setFireAffinity(Affinity.Resistente);
                stats.setIceAffinity(Affinity.Debole);
            }
            case Celestiale -> {
                stats.setLightAffinity(Affinity.Resistente);
                stats.setDarkAffinity(Affinity.Debole);
            }
            case Goblinoide -> {
                stats.setEarthAffinity(Affinity.Resistente);
                stats.setLightAffinity(Affinity.Debole);
            }
            case Djinn -> {
                stats.setAirAffinity(Affinity.Resistente);
                stats.setWaterAffinity(Affinity.Debole);
            }
            case Costrutto -> {
                stats.setIceAffinity(Affinity.Resistente);
                stats.setWaterAffinity(Affinity.Debole);
            }
            case Non_Morta -> {
                stats.setDarkAffinity(Affinity.Resistente);
                stats.setLightAffinity(Affinity.Debole);
            }
            case Sirenide -> {
                stats.setWaterAffinity(Affinity.Resistente);
                stats.setElectricityAffinity(Affinity.Debole);
            }
        }
    }

    private static void resetActualAffinity(CharacterStats stats) {
        stats.setActualPhysicalAffinity(stats.getPhysicalAffinity());
        stats.setActualWaterAffinity(stats.getWaterAffinity());
        stats.setActualEarthAffinity(stats.getEarthAffinity());
        stats.setActualFireAffinity(stats.getFireAffinity());
        stats.setActualAirAffinity(stats.getAirAffinity());
        stats.setActualElectricityAffinity(stats.getElectricityAffinity());
        stats.setActualIceAffinity(stats.getIceAffinity());
        stats.setActualLightAffinity(stats.getLightAffinity());
        stats.setActualDarkAffinity(stats.getDarkAffinity());
        stats.setActualPoisonAffinity(stats.getPoisonAffinity());
    }

    public static void sleep(CharacterStats stats) {
        stats.setActualLife(stats.getTotalLife());
        stats.setActualMana(stats.getTotalMana());

        stats.setActualInitiative(stats.getTotalInitiative());

        stats.setActualDexterity(stats.getTotalDexterity());
        stats.setActualInsight(stats.getTotalInsight());
        stats.setActualVigor(stats.getTotalVigor());
        stats.setActualWill(stats.getTotalWill());

        stats.setActualDefense(stats.getTotalDefense());
        stats.setActualResistance(stats.getTotalResistance());

        resetActualAffinity(stats);
    }
}

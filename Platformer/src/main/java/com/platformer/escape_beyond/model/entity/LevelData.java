package com.platformer.escape_beyond.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents dynamic loading of level data using a Factory Method Pattern.
 * <p>
 * LevelDataFactory provides a dynamic approach to initialize and retrieve
 * level data such as layouts, supplies, and movable object ranges.
 */
public class LevelData {
    private final List<String[]> levels;                // Stores all level layouts
    private final List<Integer> levelSupplies;          // Stores the number of supplies in each level
    private final List<List<int[]>> levelMovableObjectRanges; // Stores movable object ranges for each level

    /**
     * Private constructor to prevent direct instantiation.
     * Use the factory method {@code createLevelData()} to create an instance.
     */
    private LevelData(List<String[]> levels, List<Integer> levelSupplies, List<List<int[]>> levelMovableObjectRanges) {
        this.levels = levels;
        this.levelSupplies = levelSupplies;
        this.levelMovableObjectRanges = levelMovableObjectRanges;
    }

    /**
     * Factory method to create and initialize level data dynamically.
     *
     * @return A fully initialized {@code LevelData} object.
     */
    public static LevelData createLevelData() {
        // Initialize levels
        List<String[]> levels = new ArrayList<>();
        levels.add(new String[] {
                "0000000000000000000000000000000000000000000000000000000000000000000",
                "0000000000000000000000000000600000111000000000000000000000000000000",
                "0000000000000000000000000000100001111100000000000000000000000000000",
                "0000000000000000000000000000000000000000000000000000000000000000000",
                "0000000000000000000060000000000000000001110000000000000000000000000",
                "0000600000000000000030000000000000000011111000700000000700000000000",
                "0000111000000000000030000000000000000000000000300000001110000000000",
                "0000000000000000000330000000000000000000000000300000000000000000000",
                "0000000000000300001110000000000200000000000033330000000000000000000",
                "0000000000000330000000000000000000000000000033330000000000300000000",
                "0000000200003333000000002020700202000000000333330000000000300900000",
                "1111000111111111114440001111100111111555000111110000055511111111111",
        });
        levels.add(new String[] {
                "0000000000000000000000000000000000000000000000000000000000000000000",
                "1111110000000007000000000000111100000800000000000000000000280000000",
                "0000001100001111050000000000000001111100000000000000000011110000000",
                "0000000000000000011100000000000000000000000000000000300000000000000",
                "0700011000000000000090000000307000000090000000000011111000004000000",
                "0111111100400000000000000000111100000000000000000000000000070000000",
                "0000111100000000000000000000000000000000000000000000000000110000000",
                "0600000000000020000000000000000000000000000003000001111100000000000",
                "0111111000011111005000020000000000005800000001110000000000000000000",
                "0000000000000000111111110000006000011111111000000000000000000000000",
                "0000000000000000000000000011111100000000000000000000000723300a00000",
                "0000000000000000000000000000000000000000000000000001111111111111111",
        });

        // Initialize supplies for each level
        List<Integer> levelSupplies = new ArrayList<>();
        levelSupplies.add(6);  // Supplies for level 1
        levelSupplies.add(10); // Supplies for level 2

        // Initialize movable object ranges for each level
        List<List<int[]>> levelMovableObjectRanges = new ArrayList<>();
        List<int[]> level1Ranges = new ArrayList<>();
        levelMovableObjectRanges.add(level1Ranges); // Level 1 has no movable ranges

        List<int[]> level2Ranges = new ArrayList<>();
        level2Ranges.add(new int[]{0, 120});
        level2Ranges.add(new int[]{0, 160});
        level2Ranges.add(new int[]{0, 320});
        level2Ranges.add(new int[]{0, 240});
        level2Ranges.add(new int[]{0, 160});
        level2Ranges.add(new int[]{0, 160});
        level2Ranges.add(new int[]{0, 160});
        level2Ranges.add(new int[]{0, 160});
        levelMovableObjectRanges.add(level2Ranges);

        return new LevelData(levels, levelSupplies, levelMovableObjectRanges);
    }

    /**
     * Gets all levels.
     *
     * @return A list of level layouts.
     */
    public List<String[]> getLevels() {
        return levels;
    }

    /**
     * Gets the supplies for each level.
     *
     * @return A list of supply counts for each level.
     */
    public List<Integer> getLevelSupplies() {
        return levelSupplies;
    }

    /**
     * Gets the movable object ranges for each level.
     *
     * @return A list of movable object ranges for each level.
     */
    public List<List<int[]>> getLevelMovableObjectRanges() {
        return levelMovableObjectRanges;
    }
}

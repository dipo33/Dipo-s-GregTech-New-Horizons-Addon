package io.github.dipo33.gtnhaddon.common.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.GT_Values;
import io.github.dipo33.gtnhaddon.common.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PlantballRecipes {

    private static final ItemStack[] PLANTBALL_PULVERIZER_OUTPUT = {new ItemStack(ModItems.TINY_PILE_OF_PLANTBALL, 1)};
    private static final ItemStack[] WOOD_PULP_PULVERIZER_OUTPUT = {Recipes.findItemStack("gregtech", "gt.metaitem.01", 2, 1809)};
    private static final ItemStack PLANTBALL_COMPRESSOR_OUTPUT = GameRegistry.findItemStack("IC2", "itemFuelPlantBall", 1);
    private static final int[] SINGLE_ITEM_GUARANTEED_CHANCE = new int[0];

    public static void register() {
        // Vanilla
        addPlantballRecipe(Blocks.tallgrass, 1); // Grass
        addPlantballRecipe(Blocks.tallgrass, 2); // Fern
        addPlantballRecipe(Blocks.waterlily, 0); // Lily Pad
        addPlantballRecipe(Blocks.vine, 0); // Vines
        addPlantballRecipesForDamage(Blocks.leaves, 0, 4); // Leaves

        // Biomes o' Plenty
        addPlantballRecipe(GameRegistry.findBlock("BiomesOPlenty", "moss"), 0); // Moss
        addPlantballRecipe(GameRegistry.findBlock("BiomesOPlenty", "coral2"), 8); // Algae
        addPlantballRecipe(GameRegistry.findBlock("BiomesOPlenty", "leaves1"), 1); // Bamboo Leaves
        addPlantballRecipe(GameRegistry.findBlock("BiomesOPlenty", "colorizedLeaves2"), 0); // Willow Leaves

        addPlantballRecipesForDamage(GameRegistry.findBlock("BiomesOPlenty", "lilyBop"), 0, 3); // Lily Pads

        Block foliage = GameRegistry.findBlock("BiomesOPlenty", "foliage");
        addPlantballRecipesForDamage(foliage, 0, 9); // Foliage
        addPlantballRecipesForDamage(foliage, 10, 16); // Foliage
        addMixedPlantballRecipe(foliage, 9); // Shrub

        Block plants = GameRegistry.findBlock("BiomesOPlenty", "plants");
        addPlantballRecipesForDamage(plants, 0, 5); // Plants
        addPlantballRecipesForDamage(plants, 6, 8); // Plants
        addPlantballRecipesForDamage(plants, 9, 15); // Plants
        addWoodPulpRecipe(plants, 5); // Thorns
        addCompressPlantballRecipe(plants, 8); // River Cane
        addMixedPlantballRecipe(plants, 15); // Root

        // ThaumCraft
        Block tcLeaves = GameRegistry.findBlock("Thaumcraft", "blockMagicalLeaves");
        addPlantballRecipe(tcLeaves, 0); // Great Wood Leaves
        addPlantballRecipe(tcLeaves, 1); // Silver Wood Leaves
    }

    /**
     * @param plant       Plant item to add recipes for
     * @param damageStart Start damage index (inclusive)
     * @param damageEnd   End damage index (exclusive)
     */
    private static void addPlantballRecipesForDamage(Item plant, int damageStart, int damageEnd) {
        for (int damage = damageStart; damage < damageEnd; ++damage) {
            addPlantballRecipe(plant, damage);
        }
    }

    private static void addPlantballRecipesForDamage(Block plant, int damageStart, int damageEnd) {
        for (int damage = damageStart; damage < damageEnd; ++damage) {
            addPlantballRecipe(plant, damage);
        }
    }

    private static void addPlantballRecipe(Item plant, int damage) {
        GT_Values.RA.addPulveriserRecipe(new ItemStack(plant, 1, damage), PLANTBALL_PULVERIZER_OUTPUT, SINGLE_ITEM_GUARANTEED_CHANCE, 40, 2);
        GT_Values.RA.addCompressorRecipe(new ItemStack(plant, 8, damage), PLANTBALL_COMPRESSOR_OUTPUT, 300, 2);
    }

    private static void addPlantballRecipe(Block plant, int damage) {
        GT_Values.RA.addPulveriserRecipe(new ItemStack(plant, 1, damage), PLANTBALL_PULVERIZER_OUTPUT, SINGLE_ITEM_GUARANTEED_CHANCE, 40, 2);
        GT_Values.RA.addCompressorRecipe(new ItemStack(plant, 8, damage), PLANTBALL_COMPRESSOR_OUTPUT, 300, 2);
    }

    private static void addMixedPlantballRecipe(Block plant, int damage) {
        addWoodPulpRecipe(plant, damage);
        addCompressPlantballRecipe(plant, damage);
    }

    private static void addCompressPlantballRecipe(Block plant, int damage) {
        GT_Values.RA.addCompressorRecipe(new ItemStack(plant, 8, damage), PLANTBALL_COMPRESSOR_OUTPUT, 300, 2);
    }

    private static void addWoodPulpRecipe(Block plant, int damage) {
        GT_Values.RA.addPulveriserRecipe(new ItemStack(plant, 1, damage), WOOD_PULP_PULVERIZER_OUTPUT, SINGLE_ITEM_GUARANTEED_CHANCE, 40, 2);
    }
}

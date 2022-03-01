package io.github.dipo33.gtnhaddon.common.recipes;

import gregtech.api.enums.GT_Values;
import ic2.core.Ic2Items;
import io.github.dipo33.gtnhaddon.common.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PlantballRecipes {

    private static final ItemStack[] PLANTBALL_PULVERIZER_OUTPUT = {new ItemStack(ModItems.TINY_PILE_OF_PLANTBALL, 1)};
    private static final ItemStack PLANTBALL_COMPRESSOR_OUTPUT = Ic2Items.plantBall;
    private static final int[] SINGLE_ITEM_GUARANTEED_CHANCE = new int[0];

    public static void register() {
        // Vanilla
        addPlantballRecipe(Blocks.tallgrass, 1); // Grass
        addPlantballRecipe(Blocks.tallgrass, 2); // Fern
        addPlantballRecipe(Blocks.waterlily, 0); // Lily Pad
        addPlantballRecipe(Blocks.vine, 0); // Vines
        addPlantballRecipesForDamage(Blocks.leaves, 0, 4); // Leaves
    }

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
}

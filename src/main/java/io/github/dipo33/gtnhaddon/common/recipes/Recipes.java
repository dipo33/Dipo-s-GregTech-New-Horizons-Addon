package io.github.dipo33.gtnhaddon.common.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class Recipes {

    public static void register() {
        PlantballRecipes.register();
    }

    public static ItemStack findItemStack(String modid, String name, int stackSize, int damage) {
        ItemStack item = GameRegistry.findItemStack(modid, name, stackSize);
        item.setItemDamage(damage);

        return item;
    }
}

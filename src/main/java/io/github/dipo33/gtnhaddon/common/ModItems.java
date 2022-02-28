package io.github.dipo33.gtnhaddon.common;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.dipo33.gtnhaddon.Reference;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    private static final List<Item> ITEMS = new ArrayList<>();

    public static final Item TINY_PILE_OF_PLANTBALL = createModItem("tiny_pile_of_plantball");

    public static void register() {
        for (Item item : ITEMS) {
            GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
        }
    }

    private static Item createModItem(String unlocalizedName) {
        final Item item = new Item()
                .setUnlocalizedName(unlocalizedName)
                .setTextureName(Reference.MODID + ":" + unlocalizedName);

        ITEMS.add(item);
        return item;
    }
}

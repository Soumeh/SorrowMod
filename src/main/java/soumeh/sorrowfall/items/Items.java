package soumeh.sorrowfall.items;

import java.util.HashMap;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Items {

	public static HashMap<String, Item> ITEMS = new HashMap<String, Item>();

    static final Item CRAFTING_TABLET = new Crafting_Tablet(new FabricItemSettings().group(ItemGroup.MISC));
    static final Item RUBY = new GemBase(new FabricItemSettings().group(ItemGroup.MISC));

    public Items() {
    	ITEMS.put("ruby", RUBY);
    	ITEMS.put("crafting_tablet", CRAFTING_TABLET);
    	System.out.print(ITEMS);
    }
}
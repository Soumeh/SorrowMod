package soumeh.sorrowfall.items;

import java.util.HashMap;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import org.lwjgl.system.CallbackI;

public class Items {

	public static HashMap<String, Item> ITEMS = new HashMap<>();

    static final Item CRAFTING_TABLET = new Crafting_Tablet("crafting_tablet", new FabricItemSettings().group(ItemGroup.MISC));
    static final Item RUBY = new GemBase("ruby", new FabricItemSettings().group(ItemGroup.MISC));
    static final Item BANJO = new BaseInstrument("banjo", "minecraft:block.note_block.banjo", new FabricItemSettings().group(ItemGroup.MISC));
    static final Item BASE_DRUM = new BaseInstrument("base_drum", "minecraft:block.note_block.banjo", new FabricItemSettings().group(ItemGroup.MISC));
}
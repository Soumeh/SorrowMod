package soumeh.sorrowfall.items;

import java.util.HashMap;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.sound.Sound;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.lwjgl.system.CallbackI;

public class Items {

	public static HashMap<String, Item> ITEMS = new HashMap<>();

    static final Item CRAFTING_TABLET = new Crafting_Tablet("crafting_tablet", new FabricItemSettings().group(ItemGroup.MISC));
    static final Item RUBY = new GemBase("ruby", new FabricItemSettings().group(ItemGroup.MISC));
    static final Item BANJO = new BaseInstrument("banjo", new SoundEvent(new Identifier("minecraft:block.note_block.banjo")), new FabricItemSettings().group(ItemGroup.MISC));
    static final Item BASE_DRUM = new BaseInstrument("base_drum", new SoundEvent(new Identifier("minecraft:block.note_block.basedrum")), new FabricItemSettings().group(ItemGroup.MISC));
}
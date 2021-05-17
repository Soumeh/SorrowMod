package soumeh.sorrowfall;

import java.util.Map.Entry;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import soumeh.sorrowfall.blocks.Blocks;
import soumeh.sorrowfall.commands.SitCommand;
import soumeh.sorrowfall.entities.Entities;
import soumeh.sorrowfall.items.Items;

public class ModInit implements ModInitializer {

	
	@Override
	public void onInitialize() {

		new Blocks();
		new Items();

		for(Entry<String, Block> entry : Blocks.BLOCKS.entrySet()) {
			Registry.register(Registry.BLOCK, new Identifier("sorrowfall", entry.getKey()), entry.getValue());
		}

		for(Entry<String, Item> entry : Items.ITEMS.entrySet()) {
			Registry.register(Registry.ITEM, new Identifier("sorrowfall", entry.getKey()), entry.getValue());
		}

		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
			if (!dedicated) {
				SitCommand.register(dispatcher);
			}
		});

		//for(Entry<String, Entity> entry : Entities.ENTITIES.entrySet()) {
		//	  Registry.register(Registry.ENTITY_TYPE, new Identifier("sorrowfall", entry.getKey()), null);
		//}
	}

}

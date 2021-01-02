package soumeh.sorrowfall.blocks;

import java.util.HashMap;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import soumeh.sorrowfall.items.Items;

public class Blocks {

	public static HashMap<String, Block> BLOCKS = new HashMap<String, Block>();

    static final Block STONE_PILLAR = new PillarBlock(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
    static final Item STONE_PILLAR_ITEM = new BlockItem(STONE_PILLAR, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
    static final Block WORLDSTONE = new Worldstone(FabricBlockSettings.of(Material.STONE).hardness(3));
    static final Item WORLDSTONE_ITEM = new BlockItem(WORLDSTONE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));

    public Blocks() {
    	BLOCKS.put("stone_pillar", STONE_PILLAR);
    	Items.ITEMS.put("stone_pillar", STONE_PILLAR_ITEM);
    	BLOCKS.put("worldstone", WORLDSTONE);
    	Items.ITEMS.put("worldstone", WORLDSTONE_ITEM);
    }

  }
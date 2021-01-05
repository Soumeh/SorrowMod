package soumeh.sorrowfall.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Crafting_Tablet extends BaseItem {

	public Crafting_Tablet(String name, Settings settings) {
		super(name, settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack item = player.getStackInHand(hand);
		return TypedActionResult.success(item);
	}
}
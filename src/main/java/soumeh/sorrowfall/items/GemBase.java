package soumeh.sorrowfall.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GemBase extends BaseItem {

	public GemBase(String name, Settings settings) {
		super(name, settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack item = player.getStackInHand(hand);
		player.sendMessage(new TranslatableText("e"));
		return TypedActionResult.success(item);
	}

	//@Override
	//public void appendTooltip(ItemStack item, World world, List<Text> tooltip, TooltipContext context) {
	//    tooltip.add(new TranslatableText("item.sorrowfall.ruby"));
	//}
	
}

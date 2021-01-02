package soumeh.sorrowfall.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GemBase extends Item {

	public GemBase(Item.Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getStackInHand(hand);
		player.sendMessage(new TranslatableText(itemstack.getTranslationKey()));
		return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, itemstack);
	}

	//@Override
	//public void appendTooltip(ItemStack item, World world, List<Text> tooltip, TooltipContext context) {
	//    tooltip.add(new TranslatableText("item.sorrowfall.ruby"));
	//}
	
}

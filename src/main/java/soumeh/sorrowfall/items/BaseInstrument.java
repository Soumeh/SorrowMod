package soumeh.sorrowfall.items;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BaseInstrument extends BaseItem {

	private final SoundEvent sound;

	public BaseInstrument(String name, SoundEvent sound, Item.Settings settings) {
		super(name, settings);
		this.sound = sound;
	}

	public boolean canMine(BlockState state, World world, BlockPos block_pos, PlayerEntity player) {
		playInstrument(world, player, true);
		System.out.print("e");
		return false;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		playInstrument(world, player, false);
		return TypedActionResult.success(player.getStackInHand(hand));
	}

	public void playInstrument(World world, PlayerEntity player, Boolean leftClick) {
		Vec3d pos = player.getPos().add(0, 2, 0);
		int value = valFromPlayerPitch(player);
		if (leftClick) {
			value += 12;
		}
		float pitch = valToPitch(value);
		//SoundEvent sound = new SoundEvent(new Identifier(item.getOrCreateTag().getString("sound")));
		world.addParticle(ParticleTypes.NOTE, pos.x, pos.y, pos.z, pitch, 0, 0);
		if (!world.isClient()) {
			world.playSound(null, pos.x, pos.y, pos.z, this.sound, SoundCategory.RECORDS, 2.0F, pitch);
		}
	}

	public int valFromPlayerPitch (PlayerEntity player) {
		float mod = (player.pitch - 90) * -1;
		mod = (mod * 12) / 180;
		mod = Math.round(mod);
		return (int) mod;
	}

	// input: int from 0 to 24
	// output: the corresponding pitch
	public float valToPitch (int val) {
		return (float) Math.pow(2, (float) val / 12) / 2;
	}

}
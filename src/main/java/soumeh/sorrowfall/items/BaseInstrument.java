package soumeh.sorrowfall.items;

import java.util.HashMap;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BaseInstrument extends BaseItem {
	public BaseInstrument(String name, String sound, Item.Settings settings) {
		super(name, settings);
		instruments.put(name, sound);
	}

	public static HashMap<String, String> instruments = new HashMap<>();

	public boolean canMine(BlockState state, World world, BlockPos block_pos, PlayerEntity player) {
		ItemStack item = player.getMainHandStack();
		Vec3d pos = player.getPos().add(0, 2, 0);
		float pitch = valToPitch(valFromPlayerPitch(player));
		SoundEvent sound = soundFromInstrument(item);
		playNote(world, pos, pitch, sound);
		return false;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack item = player.getStackInHand(hand);
		Vec3d pos = player.getPos().add(0, 2, 0);
		float pitch = valToPitch(valFromPlayerPitch(player));
		SoundEvent sound = soundFromInstrument(item);
		playNote(world, pos, pitch, sound);
		return TypedActionResult.success(item);
	}

	// add code for left click functionality (same as right click, but add + 12 to valFromPlayerPitch()

	public int valFromPlayerPitch (PlayerEntity player) {
		float mod = (player.pitch - 90) * -1;
		mod = (mod * 12) / 180;
		mod = Math.round(mod);
		return (int) mod;
	}

	// input: int from 0 to 24
	// output: the corresponding pitch
	public float valToPitch (int val) {
		return (float) Math.pow(2, (float) val / 12);
	}

	public SoundEvent soundFromInstrument(ItemStack item) {
		String[] name = item.getTranslationKey().split("\\.");
		String key = name[name.length - 1];
		String id = instruments.get(key);
		return new SoundEvent(new Identifier(id));
	}

	public void playNote(World world, Vec3d pos, float pitch, SoundEvent sound) {
		world.addParticle(ParticleTypes.NOTE, pos.x, pos.y, pos.z, pitch, 0, 0);
		world.playSound(null, pos.x, pos.y, pos.z, sound, SoundCategory.RECORDS, 3.0F, pitch);
	}

}
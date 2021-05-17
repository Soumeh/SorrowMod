package soumeh.sorrowfall.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SitCommand {

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		LiteralArgumentBuilder<ServerCommandSource> literal = CommandManager.literal("sit");
		literal.requires((source) -> source.hasPermissionLevel(0)).executes(SitCommand::execute);
		dispatcher.register(literal);
	}

	public static int execute(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
		ServerWorld world = context.getSource().getWorld();
		if (!world.isClient) {
			ServerPlayerEntity player = context.getSource().getPlayer();
			sit(world, player, player.getPos().add(0, -0.6, 0));
		}
		return Command.SINGLE_SUCCESS;
	}

	public static void sit(World world, Entity entity, Vec3d location) {
		if (entity.hasVehicle()) {
			entity.stopRiding();
		} else if (!entity.onGround) {
			AreaEffectCloudEntity mount = new AreaEffectCloudEntity(world, location.x, location.y, location.z);
			mount.setRadius(0);
			mount.setDuration(10000000);
			mount.setParticleType(new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.AIR.getDefaultState()));
			world.spawnEntity(mount);
			entity.startRiding(mount);
		}
	}
}
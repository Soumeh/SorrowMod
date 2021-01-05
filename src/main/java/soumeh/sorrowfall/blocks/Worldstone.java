package soumeh.sorrowfall.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Worldstone extends Block {
	 
    public Worldstone(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE = VoxelShapes.union(
    	    Block.createCuboidShape(0, 0, 0, 16, 3, 16),
    	    Block.createCuboidShape(1, 3, 1, 15, 6, 15),
    	    Block.createCuboidShape(2, 6, 2, 14, 8, 14),
    	    Block.createCuboidShape(3, 8, 3, 13, 22, 13),
    	    Block.createCuboidShape(2, 22, 2, 14, 24, 14),
    	    Block.createCuboidShape(0, 24, 0, 16, 27, 16),
    	    Block.createCuboidShape(2, 27, 2, 14, 30, 14),
    	    Block.createCuboidShape(4, 30, 4, 12, 32, 12)
    	    );
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
        return SHAPE;
    }

    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.BLOCK;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient) {
            if (world.canSetBlock(pos.up())) {
                // code pls
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            player.sendMessage(new LiteralText("Discovered... Soon!"));
            // actual code
        }
        return ActionResult.SUCCESS;
    }
}
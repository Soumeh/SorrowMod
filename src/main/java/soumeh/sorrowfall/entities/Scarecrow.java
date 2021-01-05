package soumeh.sorrowfall.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.network.Packet;
import net.minecraft.world.World;

public class Scarecrow extends AbstractDecorationEntity {

	protected Scarecrow(EntityType<? extends AbstractDecorationEntity> entityType, World world) {
		super(entityType, world);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getHeightPixels() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidthPixels() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void onBreak(Entity arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPlace() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Packet<?> createSpawnPacket() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

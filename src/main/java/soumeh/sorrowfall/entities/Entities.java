package soumeh.sorrowfall.entities;

import java.util.HashMap;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Entities {

	public static HashMap<String, Entity> ENTITIES = new HashMap<String, Entity>();

    static final Entity SCARECROW = new Scarecrow(null, null);

    public Entities() {
    	ENTITIES.put("scarecrow", SCARECROW);
    }
}
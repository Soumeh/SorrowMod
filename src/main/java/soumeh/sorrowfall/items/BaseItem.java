package soumeh.sorrowfall.items;

import net.minecraft.item.Item;

public class BaseItem extends Item {

    public BaseItem(String name, Settings settings) {
        super(settings);
        Items.ITEMS.put(name, this);
    }
}
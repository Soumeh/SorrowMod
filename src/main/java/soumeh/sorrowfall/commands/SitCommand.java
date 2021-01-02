package soumeh.sorrowfall.commands;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class SitCommand implements ClientModInitializer  {

	@Override
	public void onInitializeClient() {

		KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			    "key.sorrowfall.sit",
			    InputUtil.Type.KEYSYM,
			    GLFW.GLFW_KEY_X,
			    "category.sorrowfall.macros" // The translation key of the keybinding's category.
			));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
		    while (keyBinding.wasPressed()) {
		    	client.player.sendChatMessage("/sit");
		    }
		});

	}
}
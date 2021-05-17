package soumeh.sorrowfall;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ClientModInit implements ClientModInitializer {

    private static final KeyBinding sitBind = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.sorrowfall.sit", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_X, "category.sorrowfall.roleplay"));

    @Override
    public void onInitializeClient() {

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (sitBind.wasPressed()) {
                assert client.player != null;
                client.player.sendChatMessage("/sit");
            }
        });
    }
}

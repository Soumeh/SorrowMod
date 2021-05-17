package soumeh.sorrowfall.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import static com.mojang.brigadier.arguments.StringArgumentType.word;
import static net.minecraft.server.command.CommandManager.literal;

public class PianoCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher){
        dispatcher.register(literal("piano")
            .requires(source -> source.hasPermissionLevel(2)) // Must be a game master to use the command. Command will not show up in tab completion or execute to non operators or any operator that is permission level 1.
            .executes(ctx -> piano(ctx.getSource()))); // You can deal with the arguments out here and pipe them into the command.
    }

    public static int piano(ServerCommandSource source) {
        final Text text = new LiteralText("e");

        source.getEntity();
        return Command.SINGLE_SUCCESS; // Success
    }
}
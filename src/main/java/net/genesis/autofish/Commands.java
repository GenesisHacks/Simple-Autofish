package net.genesis.autofish;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.text.Text;

public class Commands {

    public static void coms(){
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(ClientCommandManager.literal("Autofish_on")
                    .executes(context -> {
                        // For versions below 1.19, replace "Text.literal" with "new LiteralText".
                        context.getSource().sendFeedback(Text.literal("Autofish on"));

                        Autofish.on = false;
                        return 1;
                    }));
        });
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(ClientCommandManager.literal("Autofish_off")
                    .executes(context -> {
                        context.getSource().sendFeedback(Text.literal("Autofish off"));
                        Autofish.on = true;
                        return 1;
                    }));
        });
    }

}

package com.evanjmarkowitz.stopmessage;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

@Plugin(
        id = "stopmessage",
        name = "StopMessage",
        description = "Display a custom message to players when stopping your Sponge server",
        authors = {
                "ejm"
        }
)
public class StopMessage {

    private final CommandSpec STOP_COMMAND = CommandSpec.builder()
            .description(Text.of("Shuts down the Minecraft server"))
            .permission("stopmessage.command.stop")
            .arguments(
                    GenericArguments.optional(
                            GenericArguments.remainingJoinedStrings(Text.of("message"))
                    )
            )
            .executor(new StopCommand())
            .build();

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        Sponge.getCommandManager().register(this, STOP_COMMAND, "stop");
    }
}

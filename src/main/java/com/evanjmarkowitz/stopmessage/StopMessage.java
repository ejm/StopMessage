package com.evanjmarkowitz.stopmessage;

import com.google.inject.Inject;
import net.kyori.adventure.text.Component;
import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.parameter.Parameter;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.RegisterCommandEvent;
import org.spongepowered.plugin.PluginContainer;
import org.spongepowered.plugin.jvm.Plugin;

@Plugin("stopmessage")
public class StopMessage {

    private final PluginContainer container;

    @Inject
    StopMessage(final PluginContainer container) {
        this.container = container;
    }

    @Listener
    public void onRegisterCommands(final RegisterCommandEvent<Command.Parameterized> event) {
        Command.Parameterized stopCommand = Command.builder()
                .shortDescription(Component.text("Shuts down the Minecraft server"))
                .permission("stopmessage.command.stop")
                .addParameter(Parameters.MESSAGE)
                .executor(new StopCommand())
                .build();
        event.register(this.container, stopCommand, "stop");
    }
}

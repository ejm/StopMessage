package com.evanjmarkowitz.stopmessage;

import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandExecutor;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.exception.CommandException;
import org.spongepowered.api.command.parameter.CommandContext;

import java.util.Optional;

public class StopCommand implements CommandExecutor {
    @Override
    public CommandResult execute(CommandContext context) throws CommandException {
        Optional<String> message = context.one(Parameters.MESSAGE);
        if (message.isPresent()) {
            Sponge.server().shutdown(LegacyComponentSerializer.legacyAmpersand().deserialize(message.get()));
        }
        else {
            Sponge.server().shutdown();
        }
        return CommandResult.success();
    }
}

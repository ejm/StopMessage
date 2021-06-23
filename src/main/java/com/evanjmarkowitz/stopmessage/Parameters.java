package com.evanjmarkowitz.stopmessage;

import org.spongepowered.api.command.parameter.Parameter;

public class Parameters {
    public static final Parameter.Value<String> MESSAGE = Parameter.remainingJoinedStrings().optional().key("message").build();
}

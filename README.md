# StopMessage
Display a custom message to players when stopping your Sponge server, written for Sponge API-7.

## Commands
* `/stop [<message>]` - Shuts down the Minecraft server with an optional message, supports ampersand [formatting codes](https://minecraft.fandom.com/wiki/Formatting_codes) (ex. `&aServer restarting! Be right back!`)

## Permissions
* `stopmessage.command.stop` - Permission for the `/stop` command

## A note on command aliasing
Sponge has a configuration option which allows for plugins to have priority for certain command names. It can be found in the `sponge.comands.aliases` node in `config/sponge/global.conf`. A configuration to enable this plugin to override `/stop` would look like this:
```hocon
commands {
  aliases {
    stop=stopmessage
  }
}
```

## License
This project is licensed under the MIT License. Please see LICENSE.txt for more information.
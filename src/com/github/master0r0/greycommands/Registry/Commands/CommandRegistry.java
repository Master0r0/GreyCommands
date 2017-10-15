package com.github.master0r0.greycommands.Registry.Commands;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {

    private Map<String,BaseCommand> commands = new HashMap<>();
    private Map<String,String> alias = new HashMap<>();

    public void registerCommand(BaseCommand command){
        if(!commands.containsKey(command.getName())){
            commands.put(command.getName(),command);
        }
    }

    public void registerAlias(String command, String alias){
        if(!this.alias.containsKey(alias)){
            this.alias.put(alias,command);
        }
    }

    public Map<String, BaseCommand> getCommands() {
        return commands;
    }

    public Map<String, String> getAlias() {
        return alias;
    }
}

package com.github.master0r0.greycommands.Registry.Commands;

import com.github.master0r0.greycommands.Commands.HelpCommand;
import com.github.master0r0.greycommands.Commands.LeaveCommand;
import com.github.master0r0.greycommands.GreyCommands;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {

    private Map<String,BaseCommand> commands = new HashMap<>();
    private Map<String,String> alias = new HashMap<>();

    public CommandRegistry(){
        GreyCommands.getCommandRegistry().registerCommand(new LeaveCommand());
        GreyCommands.getCommandRegistry().registerCommand(new HelpCommand());

        GreyCommands.getCommandRegistry().registerAlias(GreyCommands.getCommandRegistry().getCommands().get("leave"),"exit");
    }

    public void registerCommand(BaseCommand command){
        if(!commands.containsKey(command.getName())){
            commands.put(command.getName(),command);
        }
    }

    public boolean unregisterCommand(String key){
        if(commands.containsKey(key)){
            commands.remove(key);
            if(!commands.containsKey(key)) {
                for(String nAlias : alias.keySet()){
                    if(alias.get(nAlias)==key){
                        unregisterAlias(nAlias);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void registerAlias(BaseCommand command, String alias){
        if(!this.alias.containsKey(alias)){
            this.alias.put(alias,command.getName());
        }
    }

    public boolean unregisterAlias(String key){
        if(alias.containsKey(key)){
            alias.remove(key);
            if(!alias.containsKey(key))
                return true;
        }
        return false;
    }

    public Map<String, BaseCommand> getCommands() {
        return commands;
    }

    public Map<String, String> getAlias() {
        return alias;
    }
}

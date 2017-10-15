package com.github.master0r0.greycommands.Registry.Commands;

import com.github.master0r0.greycommands.GreyCommands;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.Permissions;

public class CommandExecutor {

    public static boolean execute(MessageReceivedEvent evt, String cmd, String[] args){
        if(GreyCommands.getCommandRegistry().getCommands().containsKey(cmd)){
            BaseCommand command = GreyCommands.getCommandRegistry().getCommands().get(cmd);
            if(command.guildOnly()){
                runGuildOnly(evt, command, args);
            }else{
                runGlobal(evt, command, args);
            }
        }else if(GreyCommands.getCommandRegistry().getAlias().containsKey(cmd)){
            String alias = GreyCommands.getCommandRegistry().getAlias().get(cmd);
            if(GreyCommands.getCommandRegistry().getCommands().containsKey(alias)){
                BaseCommand command = GreyCommands.getCommandRegistry().getCommands().get(alias);
                if(command.guildOnly()){
                    runGuildOnly(evt, command, args);
                }else{
                    runGlobal(evt, command, args);
                }
            }
        }
        return false;
    }

    public static boolean runGuildOnly(MessageReceivedEvent evt, BaseCommand command, String[] args){
        for(IRole role : evt.getAuthor().getRolesForGuild(evt.getGuild())){
            for(Permissions perm : role.getPermissions()){
                if(perm.ordinal() == command.requiredPermission().getPermNum() || evt.getAuthor().getName().equals(GreyCommands.getSuperuser())){
                    if(command.execute(evt, args))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean runGlobal(MessageReceivedEvent evt, BaseCommand command, String[] args){
        if(command.requiredPermission()!=null)
            if(evt.getAuthor().getName().equals(GreyCommands.getSuperuser())){
                command.execute(evt,args);
            }
        else
            command.execute(evt,args);
        return false;
    }

}

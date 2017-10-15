package com.github.master0r0.greycommands.Commands;

import com.github.master0r0.greycommands.GreyCommands;
import com.github.master0r0.greycommands.Permissions.MinimalPermission;
import com.github.master0r0.greycommands.Registry.Commands.BaseCommand;
import com.github.master0r0.greycommands.Registry.Permissions.BasePermission;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IPrivateChannel;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.Permissions;

public class HelpCommand extends BaseCommand {
    @Override
    public String getName(){
        return "help";
    }

    @Override
    public boolean execute(MessageReceivedEvent evt, String[] args){
        IPrivateChannel pmChannel = evt.getAuthor().getOrCreatePMChannel();
        StringBuilder help = new StringBuilder();
        help.append("Commands you can use on server "+evt.getGuild().getName()+" are:\n")
                .append("-------------------------------------\n");
        for(String cmd : GreyCommands.getCommandRegistry().getCommands().keySet()){
            if(GreyCommands.getCommandRegistry().getCommands().get(cmd).requiredPermission().getPermNum()!=100){
                boolean found = false;
                for(IRole role : evt.getAuthor().getRolesForGuild(evt.getGuild())){
                    if(!found) {
                        for (Permissions perm : role.getPermissions()) {
                            if (GreyCommands.getCommandRegistry().getCommands().get(cmd).requiredPermission().getPermNum() == perm.ordinal()) {
                                found = true;
                                if(GreyCommands.getCommandRegistry().getCommands().get(cmd).getHelp()!="")
                                    help.append(String.format("!%s: %s\n", cmd, GreyCommands.getCommandRegistry().getCommands().get(cmd).getHelp()));
                            }
                            if(found)
                                break;
                        }
                    }
                }
            }else{
                if(evt.getAuthor().getName().equals(GreyCommands.getSuperuser()))
                    help.append(String.format("!%s: %s\n", cmd, GreyCommands.getCommandRegistry().getCommands().get(cmd).getHelp()));
            }
        }
        pmChannel.sendMessage(help.toString());
        return true;
    }

    @Override
    public String getHelp(){
        return "";
    }

    @Override
    public boolean guildOnly(){
        return true;
    }

    @Override
    public BasePermission requiredPermission(){
        return new MinimalPermission();
    }
}

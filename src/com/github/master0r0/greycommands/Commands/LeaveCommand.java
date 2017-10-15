package com.github.master0r0.greycommands.Commands;

import com.github.master0r0.greycommands.Permissions.SuperUserPermission;
import com.github.master0r0.greycommands.Registry.Commands.BaseCommand;
import com.github.master0r0.greycommands.Registry.Permissions.BasePermission;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IGuild;

public class LeaveCommand extends BaseCommand {

    @Override
    public String getName(){
        return "leave";
    }

    @Override
    public boolean execute(MessageReceivedEvent evt, String[] args){
        evt.getAuthor().getOrCreatePMChannel().sendMessage("Leaving Now!");
        for(IGuild guild : evt.getClient().getGuilds()){
            guild.getDefaultChannel().sendMessage("Leaving Now!");
        }
        evt.getClient().logout();
        return true;
    }

    @Override
    public String getHelp(){
        return "Causes the Bot to shutdown";
    }

    @Override
    public boolean guildOnly(){
        return false;
    }

    @Override
    public BasePermission requiredPermission(){
        return new SuperUserPermission();
    }

}

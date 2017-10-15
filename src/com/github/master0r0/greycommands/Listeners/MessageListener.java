package com.github.master0r0.greycommands.Listeners;

import com.github.master0r0.greycommands.Registry.Commands.CommandExecutor;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class MessageListener {

    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent evt){
        if(evt.getMessage().getContent().startsWith("!")){
            String[] args = evt.getMessage().getContent().split(" ");
            String cmd = args[0].substring(1);
            for(int i = 1;i<args.length;i++){
                args[i-1] = args[i];
            }
            CommandExecutor.execute(evt,cmd,args);
        }
    }

}

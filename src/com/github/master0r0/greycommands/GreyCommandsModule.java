package com.github.master0r0.greycommands;

import com.github.master0r0.greycommands.Commands.HelpCommand;
import com.github.master0r0.greycommands.Commands.LeaveCommand;
import com.github.master0r0.greycommands.Listeners.MessageListener;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.modules.IModule;

public class GreyCommandsModule implements IModule {

    private static GreyCommandsModule instance;
    private MessageListener listener = new MessageListener();

    private IDiscordClient client;


    @Override
    public boolean enable(IDiscordClient iDiscordClient) {
        instance = this;
        this.client = iDiscordClient;
        client.getDispatcher().registerListener(listener);
        GreyCommands.logger.info("Commands Module Started!");

        GreyCommands.getCommandRegistry().registerCommand(new LeaveCommand());
        GreyCommands.getCommandRegistry().registerCommand(new HelpCommand());
        return true;
    }

    public static GreyCommandsModule getInstance() {
        return instance;
    }

    @Override
    public void disable() {
        client.getDispatcher().unregisterListener(listener);
        GreyCommands.logger.info("Commands Module Shutting Down!");
    }

    @Override
    public String getName() {
        return "GreyCommands";
    }

    @Override
    public String getAuthor() {
        return "Master0r0";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String getMinimumDiscord4JVersion() {
        return "2.9.1";
    }

}

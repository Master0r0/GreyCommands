package com.github.master0r0.greycommands;

import com.github.master0r0.greycommands.Registry.Commands.CommandRegistry;
import com.github.master0r0.greycommands.Registry.Permissions.PermissionRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreyCommands {

    public static Logger logger = LoggerFactory.getLogger("GreyCommands");

    private static CommandRegistry commandRegistry = new CommandRegistry();
    private static PermissionRegistry permissionRegistry = new PermissionRegistry();
    private static String superuser;

    public static CommandRegistry getCommandRegistry() {
        return commandRegistry;
    }

    public static void getCommands(){
        for(String cmd : getCommandRegistry().getCommands().keySet()){
            logger.info(cmd);
        }
    }

    public static PermissionRegistry getPermissionRegistry() {
        return permissionRegistry;
    }

    public static String getSuperuser() {
        return superuser;
    }

    public static void setSuperuser(String iSuperuser) {
        superuser = iSuperuser;
    }
}

package com.github.master0r0.greycommands.Registry.Permissions;

public abstract class BasePermission {

    public String getName(){
        return "";
    }

    public int getPermNum(){
        return 0;
    }

    public boolean getSuperOverride(){
        return false;
    }


}
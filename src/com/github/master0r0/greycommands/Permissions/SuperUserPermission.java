package com.github.master0r0.greycommands.Permissions;

import com.github.master0r0.greycommands.Registry.Permissions.BasePermission;

public class SuperUserPermission extends BasePermission {

    @Override
    public String getName(){
        return "Super User";
    }

    @Override
    public int getPermNum(){
        return 100;
    }

    @Override
    public boolean getSuperOverride(){
        return true;
    }
}

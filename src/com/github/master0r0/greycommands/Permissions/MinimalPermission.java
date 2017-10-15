package com.github.master0r0.greycommands.Permissions;

import com.github.master0r0.greycommands.Registry.Permissions.BasePermission;

public class MinimalPermission extends BasePermission {
    @Override
    public String getName(){
        return "minimal";
    }

    @Override
    public int getPermNum(){
        return 0;
    }

    @Override
    public boolean getSuperOverride(){
        return true;
    }

}

package com.github.master0r0.greycommands.Registry.Permissions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PermissionRegistry {
    private final Map<String, BasePermission> permissions;

    public PermissionRegistry() {
        this.permissions = new HashMap<>();
    }

    public Map<String, BasePermission> getAllPermissions() {
        return Collections.unmodifiableMap(permissions);
    }

    public BasePermission addPermission(String key, BasePermission perm){
        if (!permissions.containsKey(key)) {
            permissions.put(key, perm);
            return permissions.get(key);
        }
        return null;
    }

    public BasePermission getPermission(String key){
        if(permissions.containsKey(key))
            return permissions.get(key);
        return null;
    }
}

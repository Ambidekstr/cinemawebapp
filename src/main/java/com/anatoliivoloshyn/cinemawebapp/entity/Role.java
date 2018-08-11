package com.anatoliivoloshyn.cinemawebapp.entity;

public class Role {
    private long roleId;

    private String role;

    public Role() {
    }

    public Role(long roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }

    public long getRoleId() {

        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

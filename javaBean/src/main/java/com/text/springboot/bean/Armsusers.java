package com.text.springboot.bean;

public class Armsusers {
    private String usersname;

    private String userspwd;

    private String userType;

    public String getUsersname() {
        return usersname;
    }

    public void setUsersname(String usersname) {
        this.usersname = usersname;
    }

    public String getUserspwd() {
        return userspwd;
    }

    public void setUserspwd(String userspwd) {
        this.userspwd = userspwd;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", usersname=").append(usersname);
        sb.append(", userspwd=").append(userspwd);
        sb.append(", userType=").append(userType);
        sb.append("]");
        return sb.toString();
    }
}
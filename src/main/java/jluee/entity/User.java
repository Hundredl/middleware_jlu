package jluee.entity;

import java.io.Serializable;

/**
 * @author 吴非凡
 */
public class User implements Serializable {

    private static final long serialVersionUID = -7304200865751828050L;

    private String userName;

    private String role;

    private String password;

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
package com.example.whatsapp_clone.Models;

public class Users {
    String username, password, email, profilepic, userID, lastMassage, status;
    public Users(){

    }

    public Users(String username, String password, String email, String profilepic, String userID, String lastMassage, String status) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.profilepic = profilepic;
        this.userID = userID;
        this.lastMassage = lastMassage;
        this.status = status;
    }

    public Users(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLastMassage() {
        return lastMassage;
    }

    public void setLastMassage(String lastMassage) {
        this.lastMassage = lastMassage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

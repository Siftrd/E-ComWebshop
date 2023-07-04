/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author rioxv
 */
public class Account {
    private int userID;
    private String userName;
    private String passWord;
    private int isSeller;
    private int isAdmin;

    public Account() {
    }

    public Account(int userID, String userName, String passWord, int isSeller, int isAdmin) {
        this.userID = userID;
        this.userName = userName;
        this.passWord = passWord;
        this.isSeller = isSeller;
        this.isAdmin = isAdmin;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(int isSeller) {
        this.isSeller = isSeller;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Account{" + "userID=" + userID + ", userName=" + userName + ", passWord=" + passWord + ", isSeller=" + isSeller + ", isAdmin=" + isAdmin + '}';
    }
    
}

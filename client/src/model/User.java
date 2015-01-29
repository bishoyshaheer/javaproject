/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;

/**
 *
 * @author it
 */
public class User implements IUser {

    private String userEmail;
    private String userPassword;
    private String userName;
    private String userGender;
    private int userState;
    private ImageIcon userImage;
    private String userStatus;
    /*About user Profile*/
    public Vector<Contact> userContacts = new Vector<Contact>();
    public Vector<Room> userRooms = new Vector<Room>();
    public Vector<Contact> userRequests = new Vector<>();
    //want to make vector of friend Requests

    public User(String userEmail, String userPassword, String userName, String userGender) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userGender = userGender;
    }

    public User() {
    }

    public String getUserEmail() {
        return userEmail;
    }

    public boolean setUserEmail(String userEmail) {
        if(validEmail(userEmail)){
            this.userEmail = userEmail;
            return true;
        } else {
            return false;
        }
        
    }

    public String getUserPassword() {
        return userPassword;
    }

    public boolean setUserPassword(String userPassword) {
        if(validPassword(userPassword)){
            this.userPassword = userPassword;
            return true;
        } else {
            return false;
        }
        
    }

    public String getUserName() {
        return userName;
    }

    public boolean setUserName(String userName) {
        if(validUserName(userName)){
            this.userName = userName;
            return true;
        } else {
            return false;
        }
        
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }

    public ImageIcon getUserImage() {
        return userImage;
    }

    public void setUserImage(ImageIcon userImage) {
        this.userImage = userImage;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public static boolean validEmail(String mail) {
        //"^(.+)@([^@]+[^.])$"
        if (mail.matches("^(.+)@([^@]+[^.])$")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validUserName(String name) {
        //"^(.+)@([^@]+[^.])$"
        if (name.matches("^([a-zA-z_]{5,30})$")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validPassword(String pass) {
        //"^(.+)@([^@]+[^.])$"
        if (pass.matches("^([a-zA-z_&%$-.]{6,20})$")) {
            return true;
        } else {
            return false;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author it
 */
public interface IUser extends Serializable{

    public String getUserEmail();

    public boolean setUserEmail(String userEmail);

    public String getUserPassword();

    public boolean setUserPassword(String userPassword);

    public String getUserName();

    public boolean setUserName(String userName);

    public String getUserGender();

    public void setUserGender(String userGender);

    public int getUserState();

    public void setUserState(int userState);

    public ImageIcon getUserImage();

    public void setUserImage(ImageIcon userImage);

    public String getUserStatus();

    public void setUserStatus(String userStatus);
}

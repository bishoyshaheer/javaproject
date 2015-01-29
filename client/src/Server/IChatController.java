/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.File;
import java.rmi.RemoteException;
import javax.swing.ImageIcon;
import model.*;
import rmi.client.IClientListener;

/**
 *
 * @author it
 */
public interface IChatController {

    public void addUser(User user);

    public void addContact(Contact contact);

    public void removeContact(String emailId);

    public void acceptFriend(User user,Contact contact);

    public void rejectFriend(User user,Contact contact);

    public void changeState(int state);

    public void changeStatus(User user);

    public void ChangeProfilePic(ImageIcon image);

    public void leaveConversation(String email);

    public void sendMessage(Room room,Message msg);

    public void sendFile(byte[] file);
    
    public void recieveFile(byte[] file);

    public void addContactToRoom(Contact contact);
    //register and unregister
     public void register(String mail, IClientListener clientRef);

     
   public void unRegister(String mail);

    
    public void startConversation(Room room, User user);

    public void signIn(User user,IClientListener clientListener);

}

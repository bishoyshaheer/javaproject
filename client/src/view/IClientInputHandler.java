/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import model.Contact;
import model.Message;
import model.Room;
import model.User;
import rmi.client.IClientListener;

/**
 *
 * @author Radwa Manssour
 */
public interface IClientInputHandler {
    
    public void sendFile(byte[] bs);
    public void reciveFile(byte[] bs);
    public void signUp(User user);
    public void signIn(User user);
    public void addContact(String mail);
    public void removeContact(String mail);    
    public void changePhoto(User user);
    public void changeStatus(User user);
    public void changeState(User user);
    public void sendMessage(Room room,Message message);
    public void addMember(int RoomId,String mail);
    public void leaveConversation(int RoomId);
    public void acceptContact(User user,Contact contact);
    public void rejectContact(User user, Contact contact);
    public void displayMessage(Message message);
    public void register(User user , IClientListener cl);
    public void startConversation(Room room ,User user);
    
    
    
}

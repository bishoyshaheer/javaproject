/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DatabaseHandler.UserData;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import model.*;
import rmi.client.*;


/**
 *
 * @author sarah
 */
public class ChatModel implements IChatModel {

  
    User user;
    Message msg;
    String joptionPaneMassage;
    int serviceNumber;
    Contact contact;
    Room room;
    byte[] bs;
    
    public byte[] getBs() {
        return bs;
    }

    public void setBs(byte[] bs) {
        this.bs = bs;
    }
    
    
    public ChatModel() {
        
        
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    
    @Override
    public Message getMsg() {
        return msg;
    }

    @Override
    public void setMsg(Message msg) {
        this.msg = msg;
    }
    
    @Override
    public int getServiceNumber() {
        return serviceNumber;
    }
    
    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }
    
    @Override
    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String getJoptionPaneMassage() {
        return joptionPaneMassage;
    }
    
    @Override
    public void setJoptionPaneMassage(String joptionPaneMassage) {
        this.joptionPaneMassage = joptionPaneMassage;
    }
    @Override
    public Contact getContact() {
        return contact;
    }

    @Override
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    
    
}

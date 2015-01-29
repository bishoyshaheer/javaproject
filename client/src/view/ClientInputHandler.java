/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Server.IServerListner;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contact;
import model.Message;
import model.Room;
import model.User;
import pkg1.chatCui;
import rmi.client.ClientListener;
import rmi.client.IClientListener;
import view.ActionType;
import view.ClientAction;

/**
 *
 * @author Radwa Manssour
 */
public class ClientInputHandler implements IClientInputHandler {



    
    IServerListner sl;
    ClientAction ca;
    chatCui cc;
    IClientListener cl;
    public ClientInputHandler(){
        
        try {
            System.out.println("client ");
            ca = new ClientAction();
            Registry reg = LocateRegistry.getRegistry("127.0.0.1",5031);
            sl= (IServerListner)reg.lookup("ChatApp");
            
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void setCc(chatCui cc) {
        try {
            this.cc = cc;
            this.cl = new ClientListener(cc);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @Override
    public void signUp(User user) {
        
        ca.setUser(user);
        ca.setServiceNum(ActionType.SIGN_UP);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void signIn(User user) {        
        ca.setUser(user);
        ca.setServiceNum(ActionType.SIGN_IN);
        try {
            
            ca.setClientModel((IClientListener)cl);
            System.out.println(user.getUserEmail());
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            System.out.println("if this ones");
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void addContact(String mail) {
        Contact con=new Contact(mail, null, null, null, 0);
        ca.setCon(con);
        ca.setServiceNum(ActionType.ADD_CONTACT);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void removeContact(String mail) {
        Contact con=new Contact(mail, null, null, null, 0);
        ca.setCon(con);
        ca.setServiceNum(ActionType.ADD_CONTACT);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void changePhoto(User user) {
        ca.setUser(user);
        ca.setServiceNum(ActionType.CHANGE_PHOTO);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void changeStatus(User user) {
        ca.setUser(user);
        ca.setServiceNum(ActionType.CHANGE_PHOTO);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void changeState(User user) {
        ca.setUser(user);
        ca.setServiceNum(ActionType.CHANGE_STATE);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public void sendMessage(Room room,Message message) {
        ca.setMessage(message);
        ca.setRoom(room);
        ca.setServiceNum(ActionType.SEND_MESSAGE);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addMember(int RoomId, String mail) {
        Contact con=new Contact(mail, null, null, null, 0);
        Message message=new Message(RoomId, null, null, null,false);
        ca.setCon(con);
        ca.setMessage(message);
        ca.setServiceNum(ActionType.SEND_MESSAGE);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void leaveConversation(int RoomId) {
        
    }

    @Override
    public void acceptContact(User user,Contact contact) {
        /*for test*/
        Contact c=new Contact("g.h@yahho.com", null, null, null, 5);
        User u=new User("aliaa@yahoo", null, null, null);
        ca.setCon(contact);
        ca.setUser(user);
        ca.setServiceNum(ActionType.ACCEPT_FRIEND);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void rejectContact(User user, Contact contact) {
        /*for test*/
        Contact c=new Contact("g.h@yahho.com", null, null, null, 5);
        User u=new User("aliaa@yahoo", null, null, null);
        ca.setCon(contact);
        ca.setUser(user);
        ca.setServiceNum(ActionType.ACCEPT_FRIEND);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void displayMessage(Message message) {
        
    }
    
    public void register(User user , IClientListener cl){
        try {
            ca.setClientModel(cl);
            ca.setUser(user);
            ca.setServiceNum(ActionType.REGISTER);
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void startConversation(Room room ,User user){
        try {
            ca.setRoom(room);
            ca.setUser(user);
            ca.setServiceNum(ActionType.START_CONVERSATION);
            System.out.println("jjjjjjjjjjj"+ca.getRoom().contactVector.get(0));
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            System.out.println("hhhhhhhhhh");
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   // public void sendFile(byte[] bs){}

    @Override
    public void sendFile(byte[] bs) {
        System.out.println("send file b2a ");
        ca.setB(bs);
        ca.setServiceNum(ActionType.SEND_FILE);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void reciveFile(byte[] bs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

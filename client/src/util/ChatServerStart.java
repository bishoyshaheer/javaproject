/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Server.IServerListner;
import Server.ServerListner;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author it
 */
public class ChatServerStart {
     public static void main(String[] args){
        new ChatServerStart();
    }
     public ChatServerStart(){
        try {
            IServerListner obj=new ServerListner();
            Registry reg=LocateRegistry.createRegistry(5031);
            reg.rebind("ChatApp", obj);
        } catch (RemoteException ex) {
            Logger.getLogger(ChatServerStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

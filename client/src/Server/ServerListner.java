/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;


/**
 *
 * @author sarah
 */
public class ServerListner extends UnicastRemoteObject implements IServerListner {
    IserverController obj;
   
    public ServerListner() throws RemoteException{
        obj=new ServerController();
        
    }
   
    @Override
    public void processClientAction(view.IClientAction clientAction) {
         
        obj.impelmentClientAction(clientAction);
        System.out.println("servercontroller");
    }

    
    

    
}

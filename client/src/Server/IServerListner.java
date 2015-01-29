/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import view.IClientAction;

/**
 *
 * @author it
 */
public interface IServerListner extends Remote {

    public void processClientAction(view.IClientAction clientAction) throws RemoteException;

   
}

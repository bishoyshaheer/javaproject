/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import view.IClientAction;
import view.IClientInputHandler;

/**
 *
 * @author Radwa Manssour
 */
public class ServerUpdater extends UnicastRemoteObject implements IServerUpdater{
    IClientInputHandler c;
    public ServerUpdater(IClientInputHandler c)throws RemoteException{
        
        this.c=c;
    }

    @Override
    public void processClientAction(IClientAction clientAction) {
        
    }
    
    
}
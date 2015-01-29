/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi.client;

import Server.IChatModel;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Radwa Manssour
 */
public interface IClientListener extends Remote{
    public void changeModel(IChatModel chatModel) throws RemoteException;
    public void isConnected() throws RemoteException;
    
}
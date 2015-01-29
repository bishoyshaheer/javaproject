/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi.client;

import java.rmi.Remote;
import view.IClientAction;

/**
 *
 * @author Radwa Manssour
 */
public interface IServerUpdater extends Remote{
    public void processClientAction(IClientAction clientAction);
    
}
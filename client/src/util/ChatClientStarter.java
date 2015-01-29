/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Server.IChatModel;
import Server.ChatModel;
import Server.IServerListner;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import pkg1.chatCui;
import rmi.client.ClientListener;
import view.ClientInputHandler;

/**
 *
 * @author bishoy
 */
public class ChatClientStarter {
    
    public ChatClientStarter(){
        
        ClientInputHandler cih = new ClientInputHandler();
        chatCui clv = new chatCui(cih);
        cih.setCc(clv);
        clv.setVisible(true);
        
    }
    public static void main(String [] args){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chatCui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chatCui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chatCui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chatCui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new ChatClientStarter();
    }
}

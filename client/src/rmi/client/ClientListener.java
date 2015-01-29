/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client;

import Server.IChatModel;
import java.awt.CardLayout;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Room;
import model.User;
import pkg1.chatCui;
import pkg1.conversation;
import pkg1.messenger;
import view.ModelType;

/**
 *
 * @author Radwa Manssour
 */
public class ClientListener extends UnicastRemoteObject implements IClientListener {
    /* IClientView clientView;
     public ClientListener(IClientView clientView)throws RemoteException{
     this.clientView=clientView;
     }*/

    chatCui gui;

    public ClientListener(chatCui gui) throws RemoteException {
        this.gui = gui;
    }

    @Override
    public void changeModel(IChatModel chatModel) {
        switch (chatModel.getServiceNumber()) {
            case ModelType.USER_FOUND:
                User user = chatModel.getUser();
                System.out.println(user.getUserEmail() + "clientlistener");
                gui.setUser(user);
                CardLayout card = (CardLayout) gui.parentPanel.getLayout();
                gui.mess = new messenger(gui.room, gui, user);
                gui.parentPanel.add("messenger", gui.mess);
                card.show(gui.parentPanel, "messenger");
                break;

            case ModelType.SERROR_MESSAGE :
                String errorMessage=chatModel.getJoptionPaneMassage();
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null,new String(errorMessage));
            }
        });               

                break;

            case ModelType.RECIEVE_MESSAGE:
                boolean foundId = false;
                for (int i = 1; i < gui.room.rooms_tabs.getTabCount(); i++) {
                    conversation conv=(conversation)gui.room.rooms_tabs.getComponentAt(i);
                     //System.out.println(gui.room.rooms_tabs.getc);
                    int roomId=conv.getRoomId();
                    Room room=chatModel.getRoom();
                    int roomIdModel=room.getRoomId();
                    System.out.println(roomId);
                    if (roomId == roomIdModel) {
                        ((conversation) gui.room.rooms_tabs.getComponentAt(i)).text2.append("\n" + chatModel.getMsg().getSender() + " : " + chatModel.getMsg().getTxt());
                        foundId = true;
                        break;
                    }

                }
                if (!foundId) {
                    conversation conv = new conversation(gui);
                    conv.setRoomId(chatModel.getRoom().getRoomId());
                    conv.setRoom(chatModel.getRoom());
                    gui.room.rooms_tabs.insertTab(chatModel.getRoom().getName(), null, conv, null, gui.room.rooms_tabs.getTabCount());
                    conv.text2.append("\n" + chatModel.getMsg().getSender() + " : " + chatModel.getMsg().getTxt());
                        
                }
                break;
            case ModelType.RECIEVE_ROOM_ID:
                conversation conv = new conversation(gui);
                conv.setRoomId(chatModel.getRoom().getRoomId());
                conv.setRoom(chatModel.getRoom());
                gui.room.rooms_tabs.insertTab(chatModel.getRoom().getName(), null, conv, null, gui.room.rooms_tabs.getTabCount());
                break;


            case ModelType.RECICVE_FILE:
                String msg=chatModel.getJoptionPaneMassage();
                byte[] bs=chatModel.getBs();
                System.out.println("recive file ");
                JOptionPane.showMessageDialog(null,new String(msg));
                JFileChooser f = new JFileChooser();
                if (f.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    String path = f.getSelectedFile().getPath();
                try {
                    FileOutputStream fos=new FileOutputStream(path);
                    fos.write(bs);
                    fos.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ClientListener.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ClientListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;


        }

    }

    @Override
    public void isConnected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

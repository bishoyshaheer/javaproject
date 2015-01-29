/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.Serializable;
import javax.swing.ImageIcon;
import model.*;

/**
 *
 * @author it
 */
public interface IChatModel extends Serializable{

    public int getServiceNumber();

    public User getUser();

    public String getJoptionPaneMassage();

    public void setUser(User user);

    public void setJoptionPaneMassage(String joptionPaneMassage);

    public void setServiceNumber(int serviceNumber);
    
    public Contact getContact();

    public void setContact(Contact contact);
    public void setMsg(Message msg);
    public Message getMsg();
    public Room getRoom();

    public void setRoom(Room room);
    
    public byte[] getBs();

    public void setBs(byte[] bs);
    
}

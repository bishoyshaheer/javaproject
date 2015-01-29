/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Vector;
import javax.swing.ImageIcon;

/**
 *
 * @author bishoy
 */
public interface IRoom extends Serializable{
    
    public String getName();
    public ImageIcon getImg();
    int getRoomId();
}

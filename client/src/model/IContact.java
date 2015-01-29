/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author bishoy
 */
public interface IContact extends Serializable{


    public String getEmail();
    public String getName();
    public String getStatus();
    public ImageIcon getPhoto();
    public int getState();
}

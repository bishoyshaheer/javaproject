/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.ImageIcon;

/**
 *
 * @author bishoy
 */
public class Contact implements IContact{
    private String email;
    private String name;
    private String status;
    private ImageIcon photo;
    private int state;

    
    public Contact(String email,String name,String status,ImageIcon photo,int state){
        this.email = email;
        this.name = name;
        this.status = status;
        this.photo = photo;
        this.state = state;
    }

    @Override
    public String getEmail() {
        return email;
        
    }

    @Override
    public String getName() {
        return name;
        
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public ImageIcon getPhoto() {
        return photo;
    }

    @Override
    public int getState() {
        return state;
    }
    
}

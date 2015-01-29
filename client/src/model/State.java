/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author bishoy
 */
public class State implements Serializable{
    public static final int AVAILABLE = 0;
    public static final int BUSY = 1;
    public static final int AWAY = 2;
    public static final int OFFLINE = 4;
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.awt.Rectangle;

/**
 *
 * @author briuo
 */
public class Tile {
    private byte type; // type can be ground, water
    private int x;
    private int y;
    public static final int SIZE = 20;
    
    public Tile(byte type, int x, int y){
        this.type = type;
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public byte getType(){
        return this.type;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, SIZE, SIZE);
    }
    
}

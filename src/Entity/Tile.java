/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author briuo
 */
public class Tile {
    private byte type; // type can be ground, water
    private int x;
    private int y;
    
    public Tile(byte type, int x, int y){
        this.type = type;
        this.x = x;
        this.y = y;
    }
    
}

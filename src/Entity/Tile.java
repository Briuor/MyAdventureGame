
package Entity;

import java.awt.Rectangle;

public class Tile extends Entity{
    
    private byte type; // type can be ground, water
    public static final int SIZE = 32;
    
    public Tile(byte type, int x, int y){
        super(x, y);
        this.type = type;
    }
    
    public byte getType(){
        return this.type;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, SIZE, SIZE);
    }
    
}

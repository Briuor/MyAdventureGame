
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author briuo
 */
public class Rectangle {
    
    public int x,y;
    
    public Rectangle(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(x, y, 20, 20);
    }
}

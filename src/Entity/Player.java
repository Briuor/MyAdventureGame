package Entity;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author briuo
 */
public class Player {
    
    private int x;
    private int y;
    private static int SPEED = 5;
    private static int SIZE = 20;
    
    public Player(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillRect(x, y, SIZE, SIZE);
    }
    
    public void move(HashSet<String> listKeys){
        
        if(listKeys.size() >= 1) {
            
            if(listKeys.contains("LEFT"))
                this.x -= SPEED;
            if(listKeys.contains("RIGHT"))
                this.x += SPEED;
            if(listKeys.contains("DOWN"))
                this.y += SPEED;
            if(listKeys.contains("UP"))
                this.y -= SPEED;                
        }
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, SIZE, SIZE);
    }
    
    public void checkCollision(MapTest mapObj){
        Tile[][] map = mapObj.getMap();
        for(int i = 0;i < mapObj.N_ROWS; i++){
            for(int j = 0; j < mapObj.N_COLS; j++){
                Tile t = map[i][j];
                Rectangle r1 = t.getBounds();
                Rectangle r2 = this.getBounds();
                
                if(r1.intersects(r2) && t.getType() == 1){
                    handleCollision();
                }
            }
        }
    }
    
    public void handleCollision(){
        x -= 5;
    }
}

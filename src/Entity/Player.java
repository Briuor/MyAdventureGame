package Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
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
public class Player extends Entity{
    
    private static int SPEED = 4;
    private static int SIZE = 32;
    // Images for each animation
    private BufferedImage[] walkingDown = {Sprite.getSprite(0, 0), Sprite.getSprite(2, 0)};
    private BufferedImage[] walkingLeft = {Sprite.getSprite(0, 1), Sprite.getSprite(2, 1)}; // Gets the upper left images of my sprite sheet
    private BufferedImage[] walkingRight = {Sprite.getSprite(0, 2), Sprite.getSprite(2, 2)};
    private BufferedImage[] walkingUp = {Sprite.getSprite(0, 3), Sprite.getSprite(2, 3)};
    private BufferedImage[] stand = {Sprite.getSprite(1, 0)};

    // These are animation states
    private Animation walkDown = new Animation(walkingDown, 10);
    private Animation walkUp = new Animation(walkingUp, 10);
    private Animation walkLeft = new Animation(walkingLeft, 10);
    private Animation walkRight = new Animation(walkingRight, 10);
    private Animation standing = new Animation(stand, 10);

    // This is the actual animation
    private Animation animation = standing;
    
    public Player(int x, int y){
        super(x, y);
    }
    
    public void draw(Graphics g){
        g.drawImage(animation.getSprite(), x, y, null);
    }
    
    public void updateAnimation(){
        animation.update();
    }
    
    public void move(HashSet<String> listKeys){
        
        if(listKeys.size() >= 1) {
            
            if(listKeys.contains("LEFT")){
                this.x -= SPEED;
                animation = walkLeft;
            }
            if(listKeys.contains("RIGHT")){
                this.x += SPEED;
                animation = walkRight;
            }
            if(listKeys.contains("DOWN")){
                this.y += SPEED;
                animation = walkDown;
            }
            if(listKeys.contains("UP")){
                this.y -= SPEED;   
                animation = walkUp;
            }
            animation.start();

        }
        else {
            animation.stop();
            animation.reset();
        }
            
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, SIZE, SIZE);
    }
    
    public void checkCollisionMap(Map mapObj, HashSet<String> listKeys){
        Tile[][] map = mapObj.getMap();
        for(int i = 0;i < mapObj.N_ROWS; i++){
            for(int j = 0; j < mapObj.N_COLS; j++){
                Tile t = map[i][j];
                Rectangle r1 = t.getBounds();
                Rectangle r2 = this.getBounds();
                
                if(r1.intersects(r2) && t.getType() == 1){
                    handleCollision(listKeys);
                }
            }
        }
    }
    
    public void handleCollision(HashSet<String> listKeys){
        
        if(listKeys.size() >= 1) {
            
            if(listKeys.contains("LEFT")){
                this.x += SPEED;
            }
            if(listKeys.contains("RIGHT")){
                this.x -= SPEED;
            }
            if(listKeys.contains("DOWN")){
                this.y -= SPEED;
            }
            if(listKeys.contains("UP")){
                this.y += SPEED;   
            }
        }

    }
}


import Entity.Player;
import Entity.Map;
import Entity.Map;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
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
public class Game extends Canvas implements Runnable{

    private boolean running = false;
    private Thread thread;
    private Player p;
    private Map m;
    private InputHandler inputHandler;

    public void init(){
        
        setFocusable(true);

        p = new Player(0,0);
        m = new Map();
        
        inputHandler = new InputHandler();
        addKeyListener(inputHandler.getKeyListener());
    }
    
    public synchronized void start(){
        if(running)
            return;
        
        init();
        
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double ns = 1000000000 / 60;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0; 
                updates = 0;
            }
        }
    }
    
    private void tick(){
        p.move(inputHandler.getListKeys());
        p.checkCollision(m, inputHandler.getListKeys());
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return ;
        }
        
        Graphics g = bs.getDrawGraphics();
        // Draw
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        m.draw(g);
        p.draw(g);
        // end draw
        g.dispose();
        bs.show();
    }
    
    public static void main(String args[]){
        new Window(800, 600, "TypeFast", new Game());
    }
}

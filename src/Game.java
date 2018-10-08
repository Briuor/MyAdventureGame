
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

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
    private Rectangle r = new Rectangle(0,0);
    private KeyListener k = new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {           }

            @Override
            public void keyPressed(KeyEvent ke) {
                int kc = ke.getKeyCode();
                switch(kc){
                    case KeyEvent.VK_A: r.x -= 20;   break;
                    case KeyEvent.VK_S: r.y += 20;   break;
                    case KeyEvent.VK_D: r.x += 20;   break;
                    case KeyEvent.VK_W: r.y -= 20;   break;

                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {            }
        };
    
    public synchronized void start(){
        if(running)
            return;
        
        addKeyListener(k);
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
        r.draw(g);
        // end draw
        g.dispose();
        bs.show();
    }
    
    public static void main(String args[]){
        new Window(800, 600, "TypeFast", new Game());
    }
}

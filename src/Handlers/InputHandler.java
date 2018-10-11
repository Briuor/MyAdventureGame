package Handlers;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tiago
 */
public class InputHandler {
    
    private KeyListener keyListener;
    private HashSet<String> listKeys;

    public InputHandler(){
        
        this.listKeys = new HashSet<String>();
        
        this.keyListener = new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                
                switch(keyCode){
                    case KeyEvent.VK_A:
                        listKeys.add("LEFT");
                        break;
                    case KeyEvent.VK_D:
                        listKeys.add("RIGHT");
                        break;
                    case KeyEvent.VK_S:
                        listKeys.add("DOWN");
                        break;
                    case KeyEvent.VK_W:
                        listKeys.add("UP");
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { 
                int keyCode = e.getKeyCode();
                
                switch(keyCode){
                    case KeyEvent.VK_A:
                        listKeys.remove("LEFT");
                        break;
                    case KeyEvent.VK_D:
                        listKeys.remove("RIGHT");
                        break;
                    case KeyEvent.VK_S:
                        listKeys.remove("DOWN");
                        break;
                    case KeyEvent.VK_W:
                        listKeys.remove("UP");
                        break;
                }
            }
        };
    }

    public KeyListener getKeyListener(){
        return this.keyListener;
    }
    
    public HashSet<String> getListKeys(){
        return this.listKeys;
    }
}

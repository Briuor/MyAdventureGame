
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tiago
 */
public class Map {
    
    private int mapLenX;
    private int mapLenY;
    private int tileSize = 20;
    private char map[][] = {
        { 'x', 'x', 'x', 'x', 'x', 'x'},
        { 'x', 'x', 'x', 'x', 'x', 'x'},
        { 'x', 'x', 'x', 'x', 'x', 'x'},
        { 'x', 'x', 'x', 'x', 'x', 'x'},
        { 'x', 'x', 'x', 'x', 'x', 'x'},
        { 'x', 'x', 'x', 'x', 'x', 'x'},
        
    };
    
    public Map(){
        this.mapLenX = tileSize * (map[0].length-1);
        this.mapLenY = tileSize * (map.length-1);
        System.out.println(mapLenX + " " + mapLenY);
    }
    
    public void draw(Graphics g){
        int x = 0, y = 0;
        for(int i = 0; i < mapLenX; i++)
        {
            for(int j = 0; j < mapLenY; j++)
            {
                g.setColor(Color.red);
                if(map[i][j] == 'x')
                    g.fillRect(x+=20, y+=20, tileSize, tileSize);
            }
        }
    }
}
// 0,0  0,20    0,40
// 20,0 20,20   20,40
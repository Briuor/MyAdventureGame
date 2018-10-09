/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author briuo
 */
public class MapTest {
    
    private Tile map[][]; // the map is a matrix of Tiles
    private static final int N_ROWS = 30;   // number of rows in the map file
    private static final int N_COLS = 40;   // number of columns in the map file
    private static final int MAP_WIDTH = 800; // number of pixels in the width of the map
    
    public MapTest(){
        loadMap();
    }
    
    public void loadMap(){
        try{
            Scanner reader = new Scanner(new File("map1.txt"));
            while (reader.hasNext()){
                byte type = reader.nextByte();
                
                //receive each 
                createMap(type);
            }
            System.out.println("Map Loaded!");
        } catch(Exception e){ e.printStackTrace();}
    }
    
    public void createMap(byte type){
        int x = 0;
        int y = 0;
        for(int i = 0;i < N_ROWS; i++)
        {
            for(int j = 0;j < N_COLS; j++)
            {
                map[i][j] = new Tile(type, x, y);
                x += Tile.SIZE; //next Tile is at x+=Tile.SIZE than the previous
                
                //create next line of Tiles in the map
                if(x > MAP_WIDTH){
                    y+= 20;
                    x = 0;
                }
            }
        }
    }
    
    public void draw(Graphics g){
        g.setColor(Color.blue);
        for(int i = 0;i < N_ROWS; i++)
        {
            for(int j = 0;j < N_COLS; j++)
            {
                Tile t = map[i][j];
                g.drawRect(t.getX(), t.getY(), t.SIZE, t.SIZE);
            }
        }

    }
    
    public static void main(String[] args){
        new MapTest();
    }
}

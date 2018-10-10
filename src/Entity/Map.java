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
public class Map {
    public static final int N_ROWS = 30;   // number of rows in the map file
    public static final int N_COLS = 40;   // number of columns in the map file
    private static final int MAP_WIDTH = 800 - 20; // number of pixels in the width of the SCREEN - 20    
    private Tile map[][] = new Tile[N_ROWS][N_COLS]; // the map is a matrix of Tiles
    private byte typeMap[][] = new byte[N_ROWS][N_COLS];//matrix of type of the tiles
    
    public Map(){
        loadTypeTiles();
        createMap();
    }
    
    public void loadTypeTiles(){
        int i = 0;
        int j = 0;
        try{
            Scanner reader = new Scanner(new File("map1.txt"));
            while (reader.hasNext()){
                byte type = reader.nextByte();
                typeMap[i][j] = type;
                j++;
                if(j == N_COLS){
                    i++;
                    j=0;
                }
            }
            System.out.println("Map Loaded!");
        } catch(Exception e){ e.printStackTrace(); }
    }
    
    public void createMap(){
        int x = 0;
        int y = 0;
        for(int i = 0;i < N_ROWS; i++)
        {
            for(int j = 0;j < N_COLS; j++)
            {
                map[i][j] = new Tile(typeMap[i][j], x, y);

                x += Tile.SIZE; //next Tile is at x+=Tile.SIZE than the previous
                
                //create next line of Tiles in the map
                if(x > MAP_WIDTH){
                    y += Tile.SIZE; // next Row of Tiles
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
                if(t.getType() == 1){g.setColor(Color.gray);}
                else g.setColor(Color.black);

                g.fillRect(t.getX(), t.getY(), t.SIZE, t.SIZE);
            }
        }
    }
    
    public static void main(String[] args){
        new Map();
    }
    
    public Tile[][] getMap(){
        return this.map;
    }
}

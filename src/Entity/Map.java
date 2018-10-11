
package Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

public class Map {
    
    public static final int N_ROWS = 19;   // number of rows in the map file
    public static final int N_COLS = 25;   // number of columns in the map file
    private static final int MAP_WIDTH = 800 - 32; // number of pixels in the width of the SCREEN - 20    
    private Tile map[][] = new Tile[N_ROWS][N_COLS]; // the map is a matrix of Tiles
    private String mapFile = "map3.map";
    private BufferedImage[] tileSprite = TypeTile.tileSprite;
    
    public Map(){
        createMap();
    }
    
    public Map(String newMapFile){
        this.mapFile = newMapFile;
        createMap();
    }
    
    public void createMap()
    {
        int x = 0, y = 0;
        int i = 0, j = 0;
        try{
            Scanner reader = new Scanner(new File("resources/maps/" + mapFile));
            while (reader.hasNext()){
                byte type = reader.nextByte();
                map[i][j] = new Tile(type, x, y);
                j++;
                x += Tile.SIZE; //next Tile is at x+=Tile.SIZE than the previous
                
                //create next line of Tiles in the map
                if(x > MAP_WIDTH){
                    y += Tile.SIZE; // next Row of Tiles
                    x = 0;
                    i++;
                    j=0;
                }
            }
            System.out.println("Map Loaded!");
        } catch(Exception e){ e.printStackTrace(); }
    }
    
    public void draw(Graphics g){
        for(int i = 0;i < N_ROWS; i++)
        {
            for(int j = 0;j < N_COLS; j++)
            {
                Tile t = map[i][j];
                if(t.getType() == 1){g.setColor(Color.gray);}
                else g.setColor(Color.black);

                g.fillRect(t.getX(), t.getY(), t.SIZE, t.SIZE);
                //g.drawImage(chooseTileSprite(t.getType()), t.getX(), t.getY(), null);
            }
        }
    }
    
    public BufferedImage chooseTileSprite(byte type){;;
        switch(type){
            case TypeTile.GROUND: 
                return tileSprite[TypeTile.GROUND];
            case TypeTile.WALL: 
                return tileSprite[TypeTile.WALL];
        }
        //return black square
        return Sprite.getSprite(0,3);
    }
    
    public Tile[][] getMap(){
        return this.map;
    }
    
}

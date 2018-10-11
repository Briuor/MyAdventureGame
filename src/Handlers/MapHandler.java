package Handlers;

public class MapHandler {
    private String currentMapFile;
    private int newPlayerX;
    private int newPlayerY;
    
    public MapHandler(){
        currentMapFile = "map1.map";
        newPlayerX = 0;
        newPlayerY = 0;
    }
    
    //receive the x and y coordinates of the player
    //check if the map must be changed
    //return true if map changes, else return false
    public boolean checkMapChange(int px, int py){
        //check transition map1 to map2
        if(currentMapFile == "map1.map" && ((px >= 20 && px <= 40) && py <= -20)){
            this.currentMapFile = "map2.map";
            this.newPlayerX = px;   this.newPlayerY = 580;
        }
        //check transition map2 to map1
        else if(currentMapFile == "map2.map" && ((px >= 20 && px <= 40) && py >= 600)){
            this.currentMapFile = "map1.map";
            this.newPlayerX = px;   this.newPlayerY = 20;
        }
        else
            return false;
        
        return true;
    }
    
    public String getCurrentMapFile(){
        return this.currentMapFile;
    }
    
    public int getNewPlayerX(){
        return this.newPlayerX;
    }
    
    public int getNewPlayerY(){
        return this.newPlayerY;
    }
}

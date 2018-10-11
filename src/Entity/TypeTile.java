
package Entity;

import java.awt.image.BufferedImage;


public class TypeTile {
    public static final byte GROUND = 0;
    public static final byte WALL = 1;
    
    public static final BufferedImage[] tileSprite = {Sprite.getSprite(0,1), Sprite.getSprite(0, 3)};
}

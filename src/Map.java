import processing.core.PApplet;
import processing.core.PImage;

public class Map {
    PImage blockImage;
    public Map(PImage blockImage) {
        this.blockImage = blockImage;
    }

    public void draw(PApplet pApplet) {
        for(int i = 0 ; i < 20; i ++){
            pApplet.image(blockImage, 40*i, 0);
            pApplet.image(blockImage, 40*i, 560);
            pApplet.image(blockImage, 0, 40*i);
            pApplet.image(blockImage, 760, 40*i);
        }
        for(int i = 0; i < 10; i ++){
            for(int j = 0; j < 10; j ++){
                pApplet.image(blockImage, 80*j, 80*i);
            }
        }
    }
}

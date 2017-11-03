import processing.core.PApplet;
import processing.core.PImage;

public class Stone{

    PImage blockImage;
    int x, y;

    public Stone(PImage blockImage, int x, int y) {
        this.blockImage = blockImage;
        this.x = x;
        this.y = y;
    }

    public void draw(PApplet pApplet) {
        pApplet.image(blockImage, x, y);
    }
}

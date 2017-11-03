import processing.core.PApplet;
import processing.core.PImage;

public class Stone extends Block{

    public Stone(PImage blockImage, int x, int y) {
        super(blockImage, x, y);
    }

    public void draw(PApplet pApplet) {
        pApplet.image(blockImage, x, y);
    }
}

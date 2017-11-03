import processing.core.PApplet;
import processing.core.PImage;

public class Box extends Block{
    public Box(PImage blockImage, int x, int y) {
        super(blockImage, x, y);
    }

    @Override
    public void draw(PApplet pApplet) {
        pApplet.image(blockImage, x, y);
    }
}

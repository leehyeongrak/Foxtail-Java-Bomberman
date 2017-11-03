import processing.core.PApplet;
import processing.core.PImage;

abstract public class Block {
    PImage blockImage;
    int x, y;
    public Block(PImage blockImage, int x, int y) {
        this.blockImage = blockImage;
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    abstract public void draw(PApplet pApplet);

}

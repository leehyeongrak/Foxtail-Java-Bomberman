import processing.core.PApplet;
import processing.core.PImage;

public class Character {
    int x, y;
    PImage characterImage[];
    PImage movingImage[];
    int speed = 8;
    int power;
    int count;


    public Character(PImage characterImage[], PImage movingImage[], int x, int y) {
        this.characterImage = characterImage;
        this.movingImage = movingImage;
        this.x = x;
        this.y = y;
    }


    int tick = 0;
    int direction = 0;
    boolean isMoving = false;

    public void draw(PApplet pApplet) {
        tick ++;
        if(isMoving){
            pApplet.image(movingImage[tick / 10 % 5 + direction*5], x, y);
        } else{
            pApplet.image(characterImage[tick / 10 % 3 + direction*3], x, y);
        }
    }

}

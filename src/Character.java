import processing.core.PApplet;
import processing.core.PImage;

public class Character {
    int x, y;
    PImage characterImage[];

    public Character(PImage characterImage[], int x, int y) {
        this.characterImage = characterImage;
        this.x = x;
        this.y = y;
    }


    int tick = 0;
    int direction = 0;
    boolean isMoving;

    public void draw(PApplet pApplet) {
        tick ++;
//            pApplet.image(characterImage[tick / 10 % 5 + direction], x+8, y);
//            System.out.println(tick / 10 % 5 + direction);
            pApplet.image(characterImage[tick / 10 % 3 + direction], x+8, y);
            System.out.println(tick / 10 % 3 + direction);
    }

}

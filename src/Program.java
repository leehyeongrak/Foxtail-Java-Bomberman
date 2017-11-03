import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public class Program extends PApplet{
    @Override
    public void settings() {
        this.size(800, 600);
        System.out.println("Settings");
    }

    int map[][] = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 7, 1},
            {1, 3, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 3, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 3, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 3, 1},
            {1, 8, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 9, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };



    PImage stoneImage;
    PImage spriteStoneImage;

    PImage boxImage;
    PImage spriteBoxImage;

    PImage characterStayImage;
    PImage[] spriteCharacterStayImage;

    PImage characterMoveImage;
    PImage[] spriteCharacterMoveImage;

    private List<Block> stones = new ArrayList<>();
    private List<Block> boxes = new ArrayList<>();
    private Character character1p;

    @Override
    public void setup() {
        this.background(0);
        System.out.println("Setup");

        stoneSetup();
        boxSetup();
        characterSetup();
        movementSetup();
    }


    @Override
    public void draw() {
        background(0, 128, 0);
        for (Block e : stones) {
            e.draw(this);
        }

        for (Block e : boxes) {
            e.draw(this);
        }

        character1p.draw(this);
    }

    public static void main(String[] args) {
        PApplet.main("Program");
    }

    private void stoneSetup(){
        stoneImage = this.loadImage("bomberman-block.png");
        spriteStoneImage = stoneImage.get(0,120,40,40);

        for(int i = 0; i < 15; i ++){
            for(int j = 0; j < 20; j++){
                if (map[i][j] == 1){
                    stones.add(new Stone(spriteStoneImage, j*40, i*40));
                }
            }
        }
    }

    private void boxSetup(){
        boxImage = this.loadImage("bomberman-block.png");
        spriteBoxImage = boxImage.get(0,0,40,40);

        for(int i = 0; i < 15; i ++){
            for(int j = 0; j < 20; j++){
                if(map[i][j] == 0){
                    int randomNumber = (int)(Math.random()*4);
                    if(randomNumber == 0){
                        boxes.add(new Box(spriteBoxImage, j*40, i*40));
                    }
                }
            }
        }
    }

    private void characterSetup(){
        characterStayImage = this.loadImage("bomberman-stay.png");

        spriteCharacterStayImage = new PImage[12];

        for(int i = 0 ; i < 3; i ++){
            for( int j = 0 ; j < 4 ; j ++){
                spriteCharacterStayImage[j * 3  + i] = characterStayImage.get(20 * i, 32 * j, 20, 32);
            }
        }

        for(int i = 0; i < 15; i ++){
            for(int j = 0; j < 20; j++){
                int randomNumber = (int)(Math.random()*4) + 6;
                if(map[i][j] == randomNumber){
                    character1p = new Character(spriteCharacterStayImage, j*40, i*40);
                }
            }
        }
    }

    private void movementSetup(){
        characterMoveImage = this.loadImage("bomberman-movement.png");

        spriteCharacterMoveImage = new PImage[20];

        for(int i = 0 ; i < 5; i++) {
            for (int j = 0; j <4; j++) {
                spriteCharacterMoveImage[j * 5  + i] = characterStayImage.get(20 * i, 32 * j, 20, 32);
            }
        }
    }

    @Override
    public void keyPressed() {
//        character1p.characterImage = spriteCharacterMoveImage;
        if(keyCode == 37){
            character1p.direction = 9;
//            character1p.isMoving = true;
            character1p.x -= 5;
//            System.out.println("left");
        }
        if(keyCode == 38){
            character1p.direction = 6;
            character1p.y -= 5;
//            System.out.println("up");
        }
        if(keyCode == 39){
            character1p.direction = 3;
            character1p.x += 5;
//            System.out.println("right");
        }
        if(keyCode == 40){
            character1p.direction = 0;
            character1p.y += 5;
//            System.out.println("down");
        }
    }

    @Override
    public void keyReleased() {
    }
}

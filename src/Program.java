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

        stoneSetup();
        boxSetup();
        characterSetup();

        System.out.println("Setup");
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
                        map[i][j] = 5;
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

        characterMoveImage = this.loadImage("bomberman-movement.png");

        spriteCharacterMoveImage = new PImage[20];

        for(int i = 0 ; i < 5; i++) {
            for (int j = 0; j <4; j++) {
                spriteCharacterMoveImage[j * 5  + i] = characterMoveImage.get(20 * i, 32 * j, 20, 32);
            }
        }

        int randomNumber = (int)(Math.random()*4) + 6;
        for(int i = 0; i < 15; i ++){
            for(int j = 0; j < 20; j++){
                if(map[i][j] == 6){
                    character1p = new Character(spriteCharacterStayImage, spriteCharacterMoveImage, j*40, i*40);
                }
            }
        }
    }

    @Override
    public void keyPressed() {
        character1p.isMoving = true;
            if(keyCode == 37){
                character1p.direction = 3;
                if (isCollision()){
                    return;
                } else{
                    character1p.x -= character1p.speed;
                }
            }
            if(keyCode == 38){
                character1p.direction = 2;
                if (isCollision()){
                    return;
                } else{
                    character1p.y -= character1p.speed;
                }
            }
            if(keyCode == 39){
                character1p.direction = 1;
                if (isCollision()){
                    return;
                } else{
                    character1p.x += character1p.speed;
                }
            }
            if(keyCode == 40){
                character1p.direction = 0;
                if (isCollision()){
                    return;
                } else{
                    character1p.y += character1p.speed;
                }
            }
//        }

    }

    @Override
    public void keyReleased() {
        character1p.isMoving = false;
    }

    private boolean isCollision() {

        switch (keyCode){
            case 37 : if(map[character1p.y/40][(character1p.x - 4)/40] == 1|| map[(character1p.y + 31)/40][(character1p.x - 4)/40] == 1 ) {
                return true;
            }break;
            case 38 : if(map[(character1p.y - 4)/40][character1p.x/40] == 1 || map[(character1p.y - 4)/40][(character1p.x - 20)/40 + 1] == 1) {
                return true;
            }break;
            case 39 : if(map[character1p.y/40][(character1p.x + 20)/40] == 1 || map[(character1p.y + 31)/40][(character1p.x + 20)/40] == 1 ) {
                return true;
            }break;
            case 40 : if(map[((character1p.y + 32))/40][character1p.x/40] == 1 || map[((character1p.y + 32))/40][(character1p.x - 20)/40 + 1] ==1) {
                return true;
            }break;
        }
        return false;
    }
}

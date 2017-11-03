import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public class Program extends PApplet{
    @Override
    public void settings() {
        this.size(800, 600);
    }

    int map[][] = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 1},
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
            {1, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };



//    PImage spriteStay;
//    PImage[] spriteCharStay;

    PImage stoneImage;
    PImage spriteStoneImage;

    PImage boxImage;
    PImage spriteBoxImage;

    private List<Block> stones = new ArrayList<>();
    private List<Block> boxes = new ArrayList<>();


    @Override
    public void setup() {
        this.background(0);
        System.out.println("Setup");





//        spriteStay = this.loadImage("bomberman-stay.png");
//
//        spriteCharStay = new PImage[12];
//
//        for(int i = 0 ; i < 3; i ++){
//            for( int j = 0 ; j < 4 ; j ++){
//                spriteCharStay[j * 3  + i] = spriteStay.get(20 * i, 32 * j, 20, 32);
//            }
//        }

        stoneSetup();
        boxSetup();
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

}

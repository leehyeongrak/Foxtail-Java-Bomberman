import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public class Program extends PApplet{
    @Override
    public void settings() {
        this.size(800, 600);
    }

//    PImage spriteStay;
//    PImage[] spriteCharStay;

    PImage stoneImage;
    PImage spriteStoneImage;

    private List<Stone> stones = new ArrayList<>();
    private Stone stone;



    @Override
    public void setup() {
        this.background(0);
        System.out.println("Setup");

        stoneImage = this.loadImage("bomberman-block.png");
        spriteStoneImage = stoneImage.get(0,120,40,40);


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

    }


    @Override
    public void draw() {
        background(0, 128, 0);
        for (Stone e : stones) {
            e.draw(this);
        }
    }

    public static void main(String[] args) {
        PApplet.main("Program");
    }

    private void stoneSetup(){
        for(int i = 0; i < 20; i++){
            stones.add(new Stone(spriteStoneImage, 40*i, 0));
            stones.add(new Stone(spriteStoneImage, 0, 40*i));
            stones.add(new Stone(spriteStoneImage, 800-40, 40*i));
            stones.add(new Stone(spriteStoneImage, 40*i, 600-40));
        }

        for(int i = 1; i < 7; i ++){
            for(int j = 1; j < 5; j ++){
                stones.add(new Stone(spriteStoneImage, 40*2*j, 40*2*i));
            }

            for(int j = 9; j > 5; j --){
                stones.add(new Stone(spriteStoneImage, 40*2*j - 40, 40*2*i));
            }
        }
    }
}

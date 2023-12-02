package ru.elena.balls;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainWindow extends JFrame {
    private static final int POS_X = 200;
    private static final int POS_Y = 50;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final int DEFAULT_COUNT_SPRITES = 10;
    private static final int MAX_COUNT_SPRITES = 15;
    private Interactable[] sprites;
    private int countSprites;
    private static final Random random = new Random();
    // private final Sprite[] sprites = new Sprite[DEFAULT_COUNT_SPRITES];


    MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("Circles");
        System.out.println("Start");

        initSprites();

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);


        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();

        }
        setVisible(true);
    }

    private void initSprites() {
        sprites = new Interactable[MAX_COUNT_SPRITES];
        sprites[0] = new Background();
        countSprites = 1;
        for (int i = 1; i < DEFAULT_COUNT_SPRITES; i++) {
            addSprite(random.nextInt(WIDTH), random.nextInt(HEIGHT));
            System.out.println("+1");
        }

    }

    public void addSprite(int x, int y){
        if (countSprites >= MAX_COUNT_SPRITES){
            throw new RuntimeException();
        }
        sprites[countSprites++] = new Ball();
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime){

        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime){
        for (int i = 0; i < countSprites; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }
    private void render(MainCanvas canvas, Graphics g){
        for (int i = 0; i < countSprites; i++) {
            sprites[i].render(canvas, g);
        }
    }
//   private void update(MainCanvas canvas, float deltaTime){
//       for (Sprite sprite : sprites ) {
//           sprite.update(canvas, deltaTime);
//       }
//   }
//    private void render(MainCanvas canvas, Graphics g){
//        for (Sprite sprite : sprites ) {
//            sprite.render(canvas, g);
//        }
//    }


}


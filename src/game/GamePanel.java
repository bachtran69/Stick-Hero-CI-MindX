package game;

import game.collum.Column;
import game.collum.Column2;
import game.player.Player;
import game.player.Stick;
import game.scene.SceneManager;
import game.scene.Welcome.WelcomeScene;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    double fps;
    Player player;
    Background background;
    Column column;
    Column2 column2;
    Boolean fallen;
    Clip music;
    public static int score;


    public GamePanel() {
//        background = new Background();
//        column = new Column();
//        column2 = new Column2();
//        player = new Player();
        fps = 0;
        fallen = false;
        SceneManager.signNewScene(new WelcomeScene());
        music = AudioUtils.loadSound("assets/music/title.wav");
        music.loop(Clip.LOOP_CONTINUOUSLY);

        score = 0;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // JPanel.paint()
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Settings.GAME_WIDTH, Settings.GAME_HEIGHT);


        GameObject.renderAll(g);

        g.setColor(Color.RED);
//        g.drawString("fps: " + fps, 700, 40);
        g.drawString("SCORE: " + score, 250, 20);
    }

    public void runAll() {
        GameObject.runAll();
    }

    public void gameLoop() {
        long lastTime = 0;
        long delay = 1000 / 70; // ~ 17
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime > delay) {
                fps = 1000 / (currentTime - lastTime);
                repaint(); // ~ call paint()
                runAll();
                lastTime = currentTime;
            }
        }
    }
}
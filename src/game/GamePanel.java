package game;

import game.collum.Column;
import game.player.Player;
import game.player.Stick;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    double fps;
    Player player;
    Background background;
    Column column;
    Stick stick;


    public GamePanel() {
        background = new Background();
        column = new Column();
        player = new Player();
        stick = new Stick();
        fps = 0;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // JPanel.paint()
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Settings.GAME_WIDTH, Settings.GAME_HEIGHT);


        GameObject.renderAll(g);

        g.setColor(Color.black);
        g.drawString("fps: " + fps, 700, 40);
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

package game.collum;

import game.GameObject;
import game.Settings;
import game.physics.BoxCollider;
import tklibs.tklibs.Mathx;

import java.awt.*;

public class Column2 extends GameObject {
    public int columnWidth;
    public int distance;
    public int x2;

    public Column2() {
        columnWidth = Mathx.random(15, 70);
        x2 = Mathx.random(150, 170);

        distance = Mathx.random(20, 80);
        position.set(x2, Settings.COLUMN_Y);
        hitBox = new BoxCollider(this, columnWidth, Settings.COLUMN_HEIGHT);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int) position.x, (int) position.y , columnWidth, Settings.COLUMN_HEIGHT);
    }
}

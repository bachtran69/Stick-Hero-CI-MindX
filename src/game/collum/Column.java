package game.collum;

import game.GameObject;
import game.KeyEventPress;
import game.Settings;
import game.Vector2D;
import game.physics.BoxCollider;
import game.player.Player;
import tklibs.tklibs.Mathx;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Column extends GameObject {
    public int columnWidth;
    public int distance;

    public Column() {
        columnWidth = Mathx.random(15, 70);

        distance = Mathx.random(20, 80);
        position.set(Settings.COLUMN_TO_EDGE - columnWidth, Settings.COLUMN_Y);
        hitBox = new BoxCollider(this, columnWidth, Settings.COLUMN_HEIGHT);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int) position.x, (int) position.y , columnWidth, Settings.COLUMN_HEIGHT);
    }
}
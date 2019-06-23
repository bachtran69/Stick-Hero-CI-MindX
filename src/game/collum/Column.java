package game.collum;

import game.GameObject;
import game.KeyEventPress;
import game.Settings;
import game.Vector2D;
import game.physics.BoxCollider;
import tklibs.tklibs.Mathx;

import java.awt.*;

public class Column extends GameObject {

    public int columnWidth;
    Vector2D midposition;
    boolean firstColumn;
    public int distance;
    public Column() {

        columnWidth = Mathx.random(10, 140);

        distance = Mathx.random(20, 80);

        firstColumn = false;
        position.set(Settings.COLUMN_TO_EDGE - columnWidth, Settings.GAME_HEIGHT - Settings.COLUMN_HEIGHT);
        hitBox = new BoxCollider(this, columnWidth, Settings.COLUMN_HEIGHT);
        velocity.set(-2,0);

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect((int) position.x, (int) position.y , columnWidth, Settings.COLUMN_HEIGHT);

    }

    @Override
    public void run() {

        if (KeyEventPress.isSpaceKeyJustRelease) {
            super.run();
    }

        this.deactiveIfNeeded();
    }


    public void deactiveIfNeeded() {
        if (this.position.x + columnWidth < 0) {
            this.deactive();
        }
    }



}

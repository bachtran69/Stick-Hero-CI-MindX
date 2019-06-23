package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.renderer.Renderer;
import game.Settings;
import game.physics.BoxCollider;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Stick extends GameObject {
    public int stickHeight;
    public boolean checkRelease;
    Graphics2D g2d;
    int angle = -180;
    boolean isFalling;

    public Stick() {
//        renderer = new Renderer("assets/images/Sprite-0001.png");
        position.set(Settings.COLUMN_TO_EDGE, Settings.GAME_HEIGHT - Settings.COLUMN_HEIGHT);
        hitBox = new BoxCollider(this, Settings.STICK_WIDTH, stickHeight);
        stickHeight=0;
        checkRelease=false;
        this.isFalling = false;
    }

    @Override
    public void run() {
        super.run();
        if (KeyEventPress.isSpacePress) {
            stickHeight += 2;
        }
        if (KeyEventPress.isSpaceKeyJustRelease){
            isFalling = true;
            if (angle < -90) {
                angle += 5;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);

        if (isFalling) {
            AffineTransform af = g2d.getTransform();
            g2d.rotate(Math.toRadians(angle), (int)this.position.x, (int)this.position.y);
            g2d.fillRect((int)position.x, (int)position.y, hitBox.width, stickHeight);
            g2d.setTransform(af);
            isFalling = false;
        } else {
            g2d.fillRect((int)position.x, (int)position.y - stickHeight, hitBox.width, stickHeight);
        }
    }
}
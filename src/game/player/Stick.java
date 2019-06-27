package game.player;

import game.GameObject;
import game.GamePanel;
import game.KeyEventPress;
import game.collum.Column2;
import game.renderer.Renderer;
import game.Settings;
import game.physics.BoxCollider;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Set;

public class Stick extends GameObject  {
    public int stickHeight;
    int angle ;
    boolean isFalling;
    int rotateSpeed = 1;

    public Stick() {
//        renderer = new Renderer("assets/images/Sprite-0001.png");
        this.angle = -180;
        rotateSpeed = 1;
        position.set(Settings.COLUMN_TO_EDGE - 2, Settings.COLUMN_Y);
        hitBox = new BoxCollider(this, Settings.STICK_WIDTH, stickHeight);
        stickHeight=0;
        this.isFalling = false;
    }

    @Override
    public void run() {
        super.run();
//        System.out.println(angle);
        if (KeyEventPress.isSpacePress) {
            stickHeight += 2;
        }
        if (KeyEventPress.isSpaceKeyJustRelease){
            isFalling = true;
            if (angle < -90) {
                angle += rotateSpeed/5;
                rotateSpeed += 1;
            } else {
                angle = -90;
                rotateSpeed = 1;
//                this.checkFallen();
            }
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D
        g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);

        if (isFalling) {
//            System.out.println("lol");
            AffineTransform af = g2d.getTransform();
            g2d.rotate(Math.toRadians(angle), (int)this.position.x, (int)this.position.y+2);
            g2d.fillRect((int)position.x, (int)position.y, hitBox.width, stickHeight);
            g2d.setTransform(af);
            isFalling = false;
        } else {
            g2d.fillRect((int)position.x, (int)position.y - stickHeight, hitBox.width, stickHeight);
        }
    }

    @Override
    public void reset() {
        this.angle = -180;
        rotateSpeed = 1;
        this.position.set(Settings.COLUMN_TO_EDGE - 2, Settings.COLUMN_Y);
        stickHeight=0;
        this.isFalling = false;
        KeyEventPress.isSpaceKeyJustRelease = false;

    }
}
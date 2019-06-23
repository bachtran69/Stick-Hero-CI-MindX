package game.renderer;

import game.GameObject;
import game.Vector2D;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Renderer {

    public BufferedImage image;
    public ArrayList<BufferedImage> images;
    public int currentImageIndex;
    public int nextImageCount;
    public boolean isOnce;

    public Renderer(String url) {
        /*
        1. Draw single image >> url = file url
        2. Draw animation >> url = dirUrl
         */
        File source = new File(url);
        if (source.isFile()) {
            image = SpriteUtils.loadImage(url);
        }
        if (source.isDirectory()) {
            images = SpriteUtils.loadImages(url);
            currentImageIndex = 0;
            nextImageCount = 0;
        }
    }

    public Renderer(String url, boolean isOnce) {
        this(url);
        this.isOnce = isOnce;
    }

    public Renderer(Vector2D position) {

    }

    public void render(Graphics g, GameObject master) {
        if (image != null) {
            this.drawImage(g, master, image);
        }

        if (images != null) {
            BufferedImage currentImage = images.get(currentImageIndex);
            this.drawImage(g, master, currentImage);

            nextImageCount++;
            if (nextImageCount > 6) {
                currentImageIndex++;
                if (currentImageIndex >= images.size()) {
                    if (isOnce) {
                        master.deactive();
                    }
                    currentImageIndex = 0;
                }
                nextImageCount = 0;
            }
        }
    }

    private void drawImage(Graphics g, GameObject master, BufferedImage image) {
        g.drawImage(
                image,
                (int) (master.position.x - image.getWidth() * master.anchor.x),
                (int) (master.position.y - image.getHeight() * master.anchor.y),
                null
        );
    }
}
//        if (master.hitBox != null) {
//            g.setColor(Color.RED);
//            g.drawRect(
//                    (int) master.hitBox.left(),
//                    (int) master.hitBox.top(),
//                    master.hitBox.width,
//                    master.hitBox.height
//            );
//        g.setColor(Color.WHITE);
//        g.fillOval(
//                (int) master.position.x -3,
//                (int) master.position.y -3,
//                5,
//                5
//            );
//        }



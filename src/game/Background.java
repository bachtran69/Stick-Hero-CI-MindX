package game;

import game.renderer.Renderer;


public class Background extends GameObject {

    public Background() {

        renderer = new Renderer("assets/images/background/3f46bb34ddebb26aabdb7f0d1e549c15.jpg");
        position.set(0,0);
        anchor.set(0,0);
    }
}


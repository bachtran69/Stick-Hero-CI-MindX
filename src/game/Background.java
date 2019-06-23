package game;

import game.renderer.Renderer;


public class Background extends GameObject {

    public Background() {

        renderer = new Renderer("assets/images/background/0.png");
//        position = new Vector2D(0, Settings.GAME_HEIGHT - 5);
//        velocity.set(1,0);
//        anchor.set(0,0);

    }
}


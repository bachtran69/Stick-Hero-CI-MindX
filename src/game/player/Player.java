package game.player;

import game.GameObject;
import game.Settings;
import game.physics.BoxCollider;
import game.renderer.Renderer;

public class Player extends GameObject {
     public Player()  {
         renderer = new Renderer("assets/images/players/");
         position.set(Settings.COLUMN_TO_EDGE-15, Settings.PLAYER_Y-3);
         hitBox = new BoxCollider(this, Settings.PLAYER_WIDTH, Settings.PLAYER_HEIGHT);
//         velocity.set(0,0);
     }

    public void go() {
        velocity.set(3,0);
    }
}

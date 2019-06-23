package game.player;

import game.GameObject;
import game.Settings;
import game.physics.BoxCollider;
import game.renderer.Renderer;

public class Player extends GameObject {
     public Player()  {

         renderer = new Renderer("assets/images/players/stickhero");
         position.set(Settings.COLUMN_TO_EDGE, Settings.GAME_HEIGHT - Settings.COLUMN_HEIGHT);
         hitBox = new BoxCollider(this, Settings.PLAYER_WIDTH, Settings.PLAYER_HEIGHT);
         velocity.set(2,0);

     }



}

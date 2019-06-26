package game.player;

import game.GameObject;
import game.Settings;
import game.collum.Column2;
import game.physics.BoxCollider;
import game.renderer.Renderer;

public class Player extends GameObject {
     public Player()  {
         renderer = new Renderer("assets/images/players/");
         position.set(Settings.COLUMN_TO_EDGE-15, Settings.PLAYER_Y-3);
         hitBox = new BoxCollider(this, Settings.PLAYER_WIDTH, Settings.PLAYER_HEIGHT);
     }

    @Override
    public void run() {
        super.run();
        Column2 column2 = GameObject.find(Column2.class);
        Stick stick = GameObject.find(Stick.class);
        if (stick.angle == -90) {
            this.velocity.set(3,0);
            if (this.position.x >= column2.position.x + column2.columnWidth - 4){
                this.velocity.set(0,0);
                this.position.x = column2.position.x + column2.columnWidth - 4;
            }
        }

    }
}

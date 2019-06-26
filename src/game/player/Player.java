package game.player;

import game.GameObject;
import game.Settings;
import game.Vector2D;
import game.collum.Column;
import game.collum.Column2;
import game.physics.BoxCollider;
import game.renderer.Renderer;

public class Player extends GameObject {
    boolean isWaiting;
    boolean canRun = false;
    boolean isFell = false;

    public Player()  {
         renderer = new Renderer("assets/images/players/");
         position.set(Settings.COLUMN_TO_EDGE-Settings.PLAYER_WIDTH*anchor.x, Settings.PLAYER_Y-3);
         isWaiting = true;
         hitBox = new BoxCollider(this, Settings.PLAYER_WIDTH, Settings.PLAYER_HEIGHT);
     }

    @Override
    public void run() {
        super.run();
        if (this.velocity.x == 0 && this.velocity.y == 0) {
            isWaiting = true;
        }
        Column column = GameObject.find(Column.class);
        Column2 column2 = GameObject.find(Column2.class);
        Stick stick = GameObject.find(Stick.class);

        // check xem player co dang waiting va o vi tri dau ko => cho chay
        if (this.isWaiting && this.position.x == Settings.COLUMN_TO_EDGE - Settings.PLAYER_WIDTH*anchor.x && stick.angle == -90  ) {
            isWaiting = false;
            this.velocity.set(2,0);
        }

        if (Settings.COLUMN_TO_EDGE + stick.stickHeight >= column2.position.x ) { //TODO: bo sung dieu kien <=
            if (this.position.x >= column2.position.x + column2.columnWidth) {

                this.velocity.set(0,0);
                isWaiting = true;
                this.position.x = column2.position.x + column2.columnWidth;

            }
        } else {
            if (this.position.x >= Settings.COLUMN_TO_EDGE + stick.stickHeight) {

                this.velocity.set(0,0);
                isWaiting = true;
                this.position.x = Settings.COLUMN_TO_EDGE + stick.stickHeight;
                this.position.y += 5;
            }
        }

        if (isWaiting && this.position.x > Settings.COLUMN_TO_EDGE - Settings.PLAYER_WIDTH*anchor.x) {
            this.fallback(stick.position, column.position, column2.position);
        }
        if (column2.position.x+column2.columnWidth==Settings.COLUMN_TO_EDGE)
            isFell = true;
        if (isFell) {
            stick.reset();
            System.out.println(stick.angle);
            isFell = false;
        }
    }

//    private void checkReset() {


    private void fallback(Vector2D stickPosition, Vector2D columnPosition, Vector2D column2Position) {
         this.position.x--;
         stickPosition.x--;
         columnPosition.x--;
         column2Position.x--;

    }
}

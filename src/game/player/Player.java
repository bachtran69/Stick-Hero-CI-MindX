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
    Stick stick;
    Column column;
    Column2 column2;


    public Player()  {
        this.stick = new Stick();
         renderer = new Renderer("assets/images/players/");
         position.set(Settings.COLUMN_TO_EDGE-Settings.PLAYER_WIDTH*anchor.x, Settings.PLAYER_Y-3);
         isWaiting = true;
         hitBox = new BoxCollider(this, Settings.PLAYER_WIDTH, Settings.PLAYER_HEIGHT);
        column = GameObject.find(Column.class);
        column2 = GameObject.find(Column2.class);

    }

    @Override
    public void run() {
        super.run();
        if (this.velocity.x == 0 && this.velocity.y == 0) {
            isWaiting = true;
        }

        // check xem player co dang waiting va o vi tri dau ko => cho chay
        if (this.isWaiting && this.position.x == Settings.COLUMN_TO_EDGE - Settings.PLAYER_WIDTH*anchor.x && stick.angle == -90  ) {
            isWaiting = false;
            this.velocity.set(2,0);
        }

        if (Settings.COLUMN_TO_EDGE + stick.stickHeight >= column2.position.x &&
                Settings.COLUMN_TO_EDGE + stick.stickHeight <= column2.position.x + column2.columnWidth) {
            if (this.position.x >= column2.position.x + column2.columnWidth - Settings.PLAYER_WIDTH/2) {
                this.velocity.set(0,0);
                isWaiting = true;
                this.position.x = column2.position.x + column2.columnWidth - Settings.PLAYER_WIDTH/2;
            }
        } else {
            if (this.position.x >= Settings.COLUMN_TO_EDGE + stick.stickHeight - Settings.PLAYER_WIDTH/2) {
                this.velocity.set(0,10);
                isWaiting = false;
                this.position.x = Settings.COLUMN_TO_EDGE + stick.stickHeight - Settings.PLAYER_WIDTH/2;
                // TODO: GAME_OVER SCENE
            }
        }

        if (isWaiting && this.position.x > Settings.COLUMN_TO_EDGE - Settings.PLAYER_WIDTH*anchor.x) {
            this.fallback(); //column.position, column2.position

        }
        if (column2.position.x+column2.columnWidth==Settings.COLUMN_TO_EDGE)
            isFell = true;
        if (isFell) {
            stick.reset();
            column2 = new Column2();
            System.out.println(stick.angle);
            this.position.x = Settings.COLUMN_TO_EDGE - Settings.PLAYER_WIDTH*anchor.x;
            isFell = false;
        }

//        if (column2.position.x <= Settings.COLUMN_TO_EDGE - Settings.PLAYER_WIDTH*anchor.x) {
//            column2.deactive();
//        }

        if (column.position.x < 0) {
            column.deactive();
        }
    }

//    private void checkReset() {

    private void fallback() { //Vector2D columnPosition, Vector2D column2Position
         this.position.x-=2;
         stick.position.x-=2;
         column.position.x-=2;
         column2.position.x-=2;
    }
}
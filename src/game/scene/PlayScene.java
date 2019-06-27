package game.scene;

import game.Background;

import game.GameObject;
import game.collum.Column;
import game.collum.Column2;
import game.player.Player;
import game.player.Stick;

public class PlayScene extends Scene {
    Player player;
    Background background;
    Column column;
    Column2 column2;

    @Override
    public void init() {
        background = new Background();
        column = new Column();
        column2 = new Column2();
        player = new Player();
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}

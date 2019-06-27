package game.scene.game_over;

import game.GameObject;
import game.scene.Scene;

public class GameOverScene extends Scene {
    @Override
    public void init() {
        GameObject.recycle(BackgroundGameOver.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}

package game.scene.Welcome;

import game.GameObject;
import game.scene.Scene;

public class WelcomeScene extends Scene {

    @Override
    public void init() {
        BackgroundWelcome background = new BackgroundWelcome();
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}

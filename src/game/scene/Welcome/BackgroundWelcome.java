package game.scene.Welcome;

import game.GameObject;
import game.KeyEventPress;
import game.renderer.Renderer;
import game.Settings;
import game.scene.PlayScene;
import game.scene.SceneManager;

public class BackgroundWelcome extends GameObject {
    public BackgroundWelcome() {
        renderer = new Renderer("assets/images/background/3f46bb34ddebb26aabdb7f0d1e549c15.jpg");
        position.set(Settings.GAME_WIDTH/2, Settings.GAME_HEIGHT/2);
    }

    @Override
    public void run() {
        super.run();
        this.checkChangeScene();
    }

    private void checkChangeScene() {
        if(KeyEventPress.isAnyKeyPress)
            SceneManager.signNewScene(new PlayScene());
    }
}

package game.scene.game_over;

import game.GameObject;
import game.KeyEventPress;
import game.renderer.Renderer;
import game.Settings;
import game.scene.PlayScene;
import game.scene.SceneManager;

public class BackgroundGameOver extends GameObject {
    public BackgroundGameOver() {
        renderer = new Renderer("assets/images/l0esstfs1v611.jpg");
        position.set(Settings.GAME_WIDTH/2, Settings.GAME_HEIGHT/2);
    }

    @Override
    public void run() {
        super.run();
        this.checkChangeScene();
    }

    int count=0;
    private void checkChangeScene() {
        count++;
        if(KeyEventPress.isAnyKeyPress && count > 60)
            SceneManager.signNewScene(new PlayScene());
    }
}

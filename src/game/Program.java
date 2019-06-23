package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;





public class Program {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setTitle("League of Legends");
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isSpacePress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isSPress = true;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isSpacePress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isSpaceKeyJustRelease = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isSPress = false;
                }

            }
        });

        GamePanel panel = new GamePanel();
        panel.setBackground(Color.CYAN);
        window.add(panel);
        panel.setPreferredSize(new Dimension(Settings.GAME_WIDTH, Settings.GAME_HEIGHT));

        window.pack();

        window.setVisible(true);

        panel.gameLoop(); // start game
    }

//
//        // ctrl + ? // comment / uncomment code
//        // alt + enter // fix code
//        // (fn +) shift + f6 // rename
//        // ctrl + alt + l // format code
//    }


    /*
    special class{ class, type
    try; catch

     */
}

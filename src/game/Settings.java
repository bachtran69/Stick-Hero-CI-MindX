package game;

import tklibs.tklibs.Mathx;

public class Settings {
    public static final int GAME_WIDTH = 360;
    public static final int GAME_HEIGHT = 640;

    public static final int PLAYER_WIDTH = 25;
    public static final int PLAYER_HEIGHT = 30;
    public static final int PLAYER_Y = 400;

    public static final int COLUMN_TO_EDGE = 70;
    public static final int COLUMN_Y = PLAYER_Y + PLAYER_HEIGHT/2 - 4;
    public static final int COLUMN_HEIGHT = GAME_HEIGHT - COLUMN_Y;

    public static final int STICK_WIDTH = 4;

//    public static final int DISTANCE_BETWEEN_COLUMN = Mathx.random(10, 100);
}

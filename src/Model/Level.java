package Model;

import View.LevelView;

public class Level {

    private static int score;
    private static Level level = null;

    private LevelView levelView;

    public Level() {}

    public static Level getLevel(){
        if(level == null) {
            level = new Level();
        }
        return level;
    }

    public void initLevel(){

    }

}

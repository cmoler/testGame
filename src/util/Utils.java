package util;

import Model.Brick;
import Model.Config;
import Model.Paddle;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class Utils {

    //public static final URL BALL_IMAGE_URL = util.Utils.class.getResource("resources/ball.png");
    //public static final URL BRICK_IMAGE_URL = util.Utils.class.getResource("resources/brick.png");
    //public static final URL PADDLE_IMAGE_URL = util.Utils.class.getResource("resources/paddle.png");
    public static final int TILE_WIDTH = 10;
    public static final int TILE_HEIGHT = 5;
    public static final int PADDLE_WIDTH = 10;
    public static final int PADDLE_HEIGHT = 5;
    public static final int TILE_HEALTH = 3;

    public static Config getLevelFromFile(String filePath){

        Config config = null;
        File file;

        try {
            file = new File(filePath);
            if (!file.exists() || file.isDirectory()) {
                throw new Exception("File " + filePath + " does not exist or is a directory");

            } else {
                if (!file.canRead()) {
                    throw new Exception("File " + filePath + " can't be read. Do you have sufficient permission?");
                }
            }

            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            String line;
            ArrayList<String> levelData = new ArrayList<String>();

            while((line = bufferedReader.readLine()) != null){
                levelData.add(line);
            }

            ArrayList<Brick> bricks = new ArrayList<>();
            Paddle paddle = null;
            for(int y = 0; y < levelData.size(); y++){
                for(int x = 0; x < levelData.get(y).length(); x++){
                    char tile = levelData.get(y).charAt(x);
                    switch (tile){
                        case 'p':
                            paddle = new Paddle(PADDLE_WIDTH, PADDLE_HEIGHT, x*TILE_WIDTH, y*TILE_HEIGHT);
                            break;
                        case 'b':
                            bricks.add(new Brick(TILE_WIDTH, TILE_HEIGHT, x*TILE_WIDTH, y*TILE_HEIGHT, TILE_HEALTH));
                    }
                }
            }

            config = new Config(bricks, paddle);

        }catch (Exception e){ }

        return config;
    }

}

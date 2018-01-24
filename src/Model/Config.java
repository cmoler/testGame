package Model;

import java.util.List;

public class Config {

    private List<Brick> bricks;
    private Paddle paddle;

    public Config(List<Brick> bricks, Paddle paddle){
        this.bricks = bricks;
        this.paddle = paddle;
    }
}

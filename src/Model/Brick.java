package Model;

public class Brick {

    private int width;
    private int height;
    private int x;
    private int y;
    private int health;

    public Brick(int width, int height, int x, int y, int health){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.health = health;
    }

    public boolean isDestroyed(){
        return health <= 0;
    }

    public void takeDamage(int damage){
        health -= damage;
    }


}

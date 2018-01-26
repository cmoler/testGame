package Model;

public class Paddle {

    private int x;
    private int y;
    private int width;
    private int height;

    public Paddle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move(DIRECTION direction){
        if(direction == DIRECTION.LEFT){
            checkCollision();
            this.x -= 5;
        }
        else if(direction == DIRECTION.RIGHT){
            checkCollision();
            this.x += 5;
        }
    }

    private boolean checkCollision(){
        return true;
    }
}

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame{

    public Game(){
        initUI();
    }

    private void initUI(){
        add(new View.Level());

        setSize(250,200);

        setTitle("OOPTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Game game = new Game();
                game.setVisible(true);
            }
        });
    }
}

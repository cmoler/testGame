package Controller;

import Model.Brick;
import Model.Paddle;
import View.LevelView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class MainController extends JFrame implements ActionListener, KeyListener{

    public static final String ACTION_NEW_GAME1 =   "newGame1";
    public static final String ACTION_ABOUT = "helpAbout";

    private Paddle paddle;
    private LevelView levelView;
    private List<Brick> bricks;
    private JPanel mainPanel;

    public MainController(){
        initUI();
    }

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainController mainController = new MainController();
                mainController.setVisible(true);
            }
        });
    }

    private void initUI(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

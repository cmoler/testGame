package Controller;

import Model.Brick;
import Model.Config;
import Model.DIRECTION;
import Model.Paddle;
import View.LevelView;
import util.Utils;

import javax.management.JMException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.List;

public class MainController extends JFrame implements ActionListener, KeyListener{

    public static final String ACTION_NEW_GAME1 = "newGame1";
    public static final String ACTION_EXIT_GAME = "exitGame";
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
        setTitle("Breakout");
        setSize(380, 460);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(getRootPane());

        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        add(menuBar, BorderLayout.NORTH);

        initMenu(menuBar);

        addKeyListener(this);

        newGame(1);
    }

    private void initMenu(JMenuBar menuBar){

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        JMenuItem newGame1 = new JMenuItem("new game");
        newGame1.setToolTipText("Start Level 1");
        newGame1.setActionCommand(ACTION_NEW_GAME1);

        JMenuItem exitGame = new JMenuItem("Exit ESC");
        exitGame.setToolTipText("Exit the game");
        exitGame.setActionCommand(ACTION_EXIT_GAME);

        newGame1.addActionListener(this);
        exitGame.addActionListener(this);

        fileMenu.add(newGame1);
        fileMenu.add(exitGame);
    }

    private void newGame(int level){
        if(levelView != null){
            mainPanel.remove(levelView);
        }
        Config config = Utils.getLevelFromFile("levels/" + level);

        paddle = config.getPaddle();
        bricks = config.getBricks();

        levelView = new LevelView();
        levelView.notifyScoreChanged(0);
        mainPanel.add(levelView, BorderLayout.CENTER);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if(action.equals(ACTION_NEW_GAME1)){
            newGame(1);
        }else if(action.equals(ACTION_EXIT_GAME)){
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode){
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_KP_LEFT:
                paddle.move(DIRECTION.LEFT);
                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_KP_RIGHT:
                paddle.move(DIRECTION.RIGHT);
                break;

            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
        }

        levelView.notifyDataChanged();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

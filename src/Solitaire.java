import GUI.GamePanel;

import javax.swing.*;
import java.io.IOException;

public class Solitaire extends JFrame {

    static protected GamePanel gamePanel;
    public static final int gamePanelWidth = 640;
    public static final int gamePanelHeight = 500;

    public Solitaire() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel = new GamePanel();
        gamePanel.setSize(gamePanelWidth, gamePanelHeight);
        add(gamePanel);
        pack();
    }


    public static void main(String[] args) throws IOException {
        new Solitaire().setVisible(true);
    }
}
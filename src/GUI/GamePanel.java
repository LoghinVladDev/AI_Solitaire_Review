package GUI;

import Gameplay.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel {

    protected static int XOffset = 80;
    public static Point deckPosition = new Point(500, 20);
    public static Point tableauPosition = new Point(20, 150);
    public static int tableauOffset = 80;
    private static Deck deck;
    private static WastePile wastePile;
    private static Foundations[] foundations;
    private static Tableau[] tableaus;
    private ShuffleButton shuffleButton;

    public GamePanel() throws IOException {
        super.setLayout(null);
        initializePiles();

        GameMoveListener gameMoveListener = new GameMoveListener();
        addMouseListener(gameMoveListener);
        addMouseMotionListener(gameMoveListener);
    }


    private void initializePiles() throws IOException {
            deck = new Deck(deckPosition.x, deckPosition.y);
            add(deck);

            wastePile = new WastePile(deckPosition.x - XOffset, deckPosition.y);
            add(wastePile);

            foundations = new Foundations[4];

            for (int i = 0; i < foundations.length; i++) {
                foundations[i] = new Foundations(20 + XOffset*i, 20, i + 1);
                add(foundations[i]);
            }

            tableaus = new Tableau[7];
            for (int i =0; i < tableaus.length; i++){
                tableaus[i] = new Tableau(tableauPosition.x + tableauOffset * (i),
                        tableauPosition.y, i +1);
                add(tableaus[i]);
            }

            shuffleButton = new ShuffleButton(600,20, 100);
            shuffleButton.setBounds(600, 20, 149, 49);
            add(shuffleButton);
    }

    public static Foundations[] getFoundations() {
        return foundations;
    }

    public static WastePile getWastePile() {
        return wastePile;
    }

    public static Deck getDeck() {
        return deck;
    }


    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        graphics.setColor(Color.green);
        graphics.fillRect(0,0, this.getWidth(), this.getHeight());
    }

}



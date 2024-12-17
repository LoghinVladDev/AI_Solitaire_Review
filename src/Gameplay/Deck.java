package Gameplay;

import Cards.Card;
import Cards.Suit;

import java.awt.*;
import java.io.IOException;
import java.util.Collections;

public class Deck extends Pile {

    public Deck(int x, int y) throws IOException {
        super(x,y);
        super.setSize(67, 97);

        for(Suit suit: Suit.values()){
            for(int i =1; i<=13; i++){
                push(new Card(suit, i));
            }
        }

        Collections.shuffle(cards);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawRect(0, 0, this.getWidth(), this.getHeight());

        if(!isEmpty()){
            graphics.drawImage(Card.getCardBack(), 0,0, this.getWidth(), this.getHeight(), this);
        } //just need to draw the card back for the deck since all the cards are face down




    }


}


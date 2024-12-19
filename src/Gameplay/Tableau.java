package Gameplay;

import Cards.Card;
import GUI.GamePanel;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Tableau extends Pile{

    public Tableau(int x, int y, int initSize) {
        super(x, y);
        super.setSize(67, 450);
        super.setOpaque(false);
        for (int i =0; i < initSize; i++){
            push(GamePanel.getDeck().pop());
        }

        if (initSize > 0){
            topCard().showFace();
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setColor(Color.WHITE);
        g2d.drawLine(0,0,this.getWidth(),0); //.getWidth() and .getHeight() come from extending JPanel
        g2d.drawLine(0,0,0, 97);
        g2d.drawLine(this.getWidth() -1, 0, this.getWidth() -1, 97);

        g2d.setPaint(new GradientPaint(36, 0, new Color(255, 255, 255, 160), 36, 60,
                new Color(0,0,0,0)));
        g2d.fillRect(0,0,this.getWidth(),this.getHeight());

        int cardYPos = 0;


        if (!this.isEmpty()){
            for (Card card: this.cards){
                if (card.isFaceUp()){
                    graphics.drawImage(card.getCardFront(), 0, cardYPos, 67, 97, this);
                    cardYPos += 20; //above reference to card object
                } else {
                    graphics.drawImage(Card.getCardBack(), 0 ,cardYPos, 67, 97, this);
                    cardYPos += 20; //above reference to card class
                }
            }
        }

    }

    public boolean accepts(Card card) {
        if(!this.isEmpty()){
         return this.topCard().getRank() == card.getRank() + 1 &&
                 !Objects.equals(this.topCard().getColor(), card.getColor());
        }
        return card.getRank() == 13;
    }

    public void moveFromWastePile(WastePile wastePile, Card card) {
        if(this.accepts(card)){
            this.push(wastePile.pop());
        }
    }

    public boolean moveToFoundation(Foundations foundation, Card card){
        if(foundation.accepts(card)) {
            foundation.push(this.pop());

            if (!this.isEmpty()) {
                this.topCard().showFace();
            }
            return true;
        }
        return false;


    }

    public void moveToOtherTableau(Tableau tableau, Card card){
        if(!this.isEmpty() || !this.isEmpty() && card.getRank() ==13){
            if(tableau.accepts(card)) {
                Deque<Card> cardsToBeMoved = new ArrayDeque<>(); //grows as needed, like a Python list
                //not thread safe

                while (!this.isEmpty()) {
                    Card top = this.pop();
                    cardsToBeMoved.push(top);
                    if (top.equals(card)) {
                        break;
                    }
                }
                while(!cardsToBeMoved.isEmpty()){
                    tableau.push(cardsToBeMoved.pop());
                }
                if(!this.isEmpty()){
                    this.topCard().showFace();
                }

            }
        }
    }

    public Card getClickedCard(int y){
        int index = y/20;
        if(index < this.cards.toArray().length){
            Card toBeReturned = (Card) cards.toArray()[index];
            if (toBeReturned.isFaceUp()){
                return toBeReturned;
            }
        }
        return (Card) cards.toArray()[cards.toArray().length - 1];
    }


}

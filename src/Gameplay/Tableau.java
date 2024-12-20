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
        super.setSize(67, 300);
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
        if(!this.isEmpty()){  //if the tableau is not empty enter the conditional statement
         return this.topCard().getRank() == card.getRank() + 1 &&  //checks if the current top card's rank is 1 higher
                                                                    //than the incoming card's rank
                 !Objects.equals(this.topCard().getColor(), card.getColor()); //and checks that their colors are different
        } //if the tableau is empty, it returns true only for Kings, which can be any color
        return card.getRank() == 13;
    }

    public void moveFromWastePile(WastePile wastePile, Card card) {
        if(this.accepts(card)){  //if the rank is satisfactory
            this.push(wastePile.pop());  //add the returned card from the wastepile
        }
    }

    public boolean moveTo(Foundations foundation, Card card){
        if(card !=null && foundation.accepts(card)) {
            foundation.push(this.pop());
            if (!this.isEmpty()) {
                this.topCard().showFace();
            }
            return true;
        }
        return false;
    }

    public void moveTo(Tableau destination, Card card) {
        if (!this.isEmpty() || card.getRank() == 13) {
            if (destination.accepts(card)) {
                Deque<Card> toBeMovedCards  = new ArrayDeque<>();
                while(!this.isEmpty()) {
                    Card top = this.pop();
                    toBeMovedCards.push(top);
                    if(top.equals(card)) {
                        break;
                    }
                }
                while(!toBeMovedCards.isEmpty()) {
                    destination.push(toBeMovedCards.pop());
                    toBeMovedCards.removeAll(cards);
                }

            }
        }

        if(!this.isEmpty()) {
            this.topCard().showFace();
        }
    }


    public Card getClickedCard(int y) {
        int faceUpStartIndex = 0;

        for (int i = 0; i < cards.size(); i++) { //gets the index of the first face up card in the tableau
            if (cards.get(i).isFaceUp()) {
                faceUpStartIndex = i;
                break;
            }
        }

        int index  = faceUpStartIndex + y/240; //250 to start with, 240 means the face up card above the previous one
                                            //begins roughly where the one below ends
        if (index < cards.size()){
            System.out.println(index);
            System.out.print(cards.get(index).getRank() + " ");
            System.out.print(cards.get(index).getSuit());
            return cards.get(index);
        }

        return cards.get(cards.size() - 1); //returns last card if index out of bounds

    }


}

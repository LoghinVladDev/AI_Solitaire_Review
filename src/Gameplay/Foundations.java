package Gameplay;

import Cards.Card;

import java.awt.*;
import java.util.Objects;

public class Foundations extends Pile {

    private int suit;

    public Foundations(int x, int y, int suitNumber) {
        super(x, y);
        super.setSize(67, 97);
        this.suit = suitNumber;
    }


    @Override
    protected void  paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        if(!this.isEmpty()){
            graphics.drawImage(this.topCard().getCardFront(), 0,0, this.getWidth(), this.getHeight(),this);
        }

    }

    public void moveTo(Tableau tableau, Card card){
        if (tableau.accepts(card)){
            tableau.push(this.pop());
        }
    }

    public void moveFromWastePile(WastePile source, Card card){
        if(accepts(card)){
            this.push(source.pop());
            source = null;
        }
    }

    public boolean accepts(Card card){
        if (!this.isEmpty()){
            //checks that the sitting card's rank is 1 smaller than the incoming card's rank

            return this.topCard().getRank() == card.getRank() - 1
                    && Objects.equals(this.topCard().getSuit(), card.getSuit());
        }
        //only aces are placed first

        return card.getRank() == 1 && //only aces are placed first
                intToSuit(card.getSuit());
    }

    private boolean intToSuit(String fileSuit) {
        return switch (fileSuit.toLowerCase()) {
            case "spades" -> this.suit == 1;
            case "hearts" -> this.suit == 2;
            case "clubs" -> this.suit == 3;
            case "diamonds" -> this.suit == 4;
            default -> false;
        };
    }






}

package Gameplay;

import Cards.Card;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class WastePile extends Pile{

    public WastePile(int x , int y){
        super(x,y);
        super.setSize(67, 97);
        cards = new Stack<Card>();
        }

    @Override
    protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            if(!this.isEmpty()){
                graphics.drawImage(this.topCard().getCardFront(), 0,0, this.getWidth(), this.getHeight(),this);
            }
    }

    public void reshuffle(Deck deck){
        if (this.isEmpty()){
            return;  //if pile is empty you cannot reshuffle it
        }

        List<Card> recycling = new ArrayList<>();
        while(!this.isEmpty()){
            recycling.add(this.pop());
        }
        Collections.shuffle(recycling);
        for(Card card : recycling){
            deck.push(card);
        }
    }



    }


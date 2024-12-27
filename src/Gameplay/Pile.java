package Gameplay;

import Cards.Card;

import javax.swing.*;
import java.awt.*;
import java.util.EmptyStackException;
import java.util.Stack;

public abstract class Pile extends JPanel {
    //class is abstract because methods defined here are needed by many other classes
    //such as the deck, the foundations, the waste pile and the stockpiles

    protected Integer x, y;   //horizontal and vertical positions in the GUI
    protected Stack<Card> cards; //a stack is better than a list because it is a LIFO data structure

    public Pile(int x, int y) {
        super.setLocation(x, y); //sets pile location by calling the method in the Jpanel class
                                 //super.someaction() just lets you call a parent class' methods
        cards = new Stack<>();
    }

   public Card topCard(){
        if (!this.cards.isEmpty()){
            return this.cards.peek(); //just look at the top card of a non-empty stack
        }
        return null;
   }

   public Card pop(){
        try {
            return this.cards.pop();
        } catch (EmptyStackException ese){
            System.out.println("Exception encountered: the stack is empty.");
            return null;
        }
   }

   public void push(Card aCard){
        this.cards.push(aCard);  //pushes a card on top of a stack
                                //will be useful for foundations or maybe undoing draw moves
   }

   public boolean isEmpty(){
        return this.cards.isEmpty();
   }


    protected void paintComponent(Graphics graphics) {
    }
}

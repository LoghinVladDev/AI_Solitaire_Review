import Cards.Card;
import Cards.Suit;
import GUI.GUI;
import Gameplay.Deck;

public class Main {
    public static void main(String[] args) {

        Deck deck = new Deck();


        for (Card card: deck.getCards()){
            System.out.println(card);
        }

        GUI gui = new GUI();

    }
}
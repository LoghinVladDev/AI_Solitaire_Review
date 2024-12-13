package Gameplay;

import Cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Foundations {

    private final List<Card> foundation;

    public Foundations() {
        foundation = new ArrayList<>(14);
    }

    public void addCard(Card card) {
        foundation.add(card); //appends it to the end of the list
    }

    public void removeCard(Card card) {
        foundation.remove(card);
    }

}

package Cards;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Card {

    private String color;
    private final Integer rank;
    private Image cardFront;
    public static String cardBackFilename = "card_back_blue";
    private boolean faceUp;
    public static String cardImageDirectory = "/Cards/cardImages", extension = ".png";
    private String suit;

    public Card(Suit suit, Integer rank) throws IOException {
        this.rank = rank;
        switch (suit) {
            case CLUBS -> {
                this.suit = "clubs";
                this.color = "black";
            }
            case DIAMONDS -> {
                this.suit = "diamonds";
                this.color = "red";
            }
            case HEARTS ->{
                this.suit = "hearts";
                this.color = "red";
            }
            case SPADES ->{
                this.suit = "spades";
                this.color = "black";
            }
        }
        faceUp = false;

        try {
             System.out.println(cardImageDirectory + parsedCardFile(suit, rank));
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(cardImageDirectory +
                    parsedCardFile(suit, rank)));
            cardFront = imageIcon.getImage();
        }catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


    private String parsedCardFile(Suit suit, int rank){
        String suit_name;

        if (rank < 1 || rank > 13){
            throw new IllegalArgumentException("Rank is either under 1 or over 13.");
        }


        if (suit == Suit.CLUBS){
            suit_name = "clubs";
        } else if (suit == Suit.DIAMONDS){
            suit_name = "diamonds";
        } else if (suit == Suit.HEARTS){
            suit_name = "hearts";
        } else if (suit == Suit.SPADES){
            suit_name = "spades";
        } else throw new IllegalArgumentException("Invalid suit name.");

        return "/" + rank +"_of_" + suit_name + extension;

    }


    public Image getCardFront() {
        return cardFront;
    }

    public Integer getRank() {
        return rank;
    }

    public String getColor() {
        return color;
    }

    public String getSuit() {
        return suit;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void showFace(){
        faceUp = true;
    }

    @Override
    public String toString() {
        return rank + "_of_" + suit;
    }


    public static Image getCardBack(){
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(Card.class.getResource(cardImageDirectory
                + "/" + cardBackFilename + extension)));

        Image image = imageIcon.getImage();
        return image;
    }


}

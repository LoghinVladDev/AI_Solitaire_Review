package Cards;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Card {
    private Suit suit;
    private Color color;
    private String rank;
    private Image cardFront;
    private final Image cardBack = ImageIO.read(new File("Solitaire\\cardImages\\card_back_blue.png"));
    private boolean faceUp;

    public Card(Suit suit, String rank, String image, String cardBack) throws IOException {
        this.rank = rank;
        switch (suit) {
            case CLUBS -> {
                this.suit = Suit.CLUBS;
                this.color = Color.BLACK;
            }
            case DIAMONDS -> {
                this.suit = Suit.DIAMONDS;
                this.color = Color.RED;
            }
            case HEARTS ->{
                this.suit = Suit.HEARTS;
                this.color = Color.RED;
            }
            case SPADES ->{
                this.suit = Suit.SPADES;
                this.color = Color.RED;
            }
        }
        faceUp = false;


    }

    public Suit getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

}

package GUI;

import Cards.Card;
import Gameplay.*;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class GameMoveListener extends MouseInputAdapter {

    private Deck deck = GamePanel.getDeck();
    private WastePile wastePile = null;
    private Tableau selectedTableau = null;
    private Foundations selectedFoundation = null;
    private Card selectedCard = null;
    private ShuffleButton selectedShuffleButton = null;


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Component pressedComponent = mouseEvent.getComponent().getComponentAt(mouseEvent.getPoint());

        if(pressedComponent instanceof Foundations) {
            selectedShuffleButton =null;
            selectedFoundation = (Foundations) pressedComponent;
            selectedTableau = null;
            wastePile = null;
            selectedCard = selectedFoundation.topCard();
        }else if (pressedComponent instanceof Tableau) {
            selectedTableau = (Tableau) pressedComponent;
            wastePile = null;
            selectedShuffleButton = null;
            selectedCard = selectedTableau.getClickedCard(mouseEvent.getY());
            for(Foundations foundations: GamePanel.getFoundations()) {
                if(selectedTableau.moveTo(foundations, selectedCard)){
                    selectedTableau = null;
                    break;
                }
            }
        } else if (pressedComponent instanceof Deck) {
            selectedTableau = null;
            selectedShuffleButton = null;
            if(!deck.isEmpty()){
                WastePile wastePile = GamePanel.getWastePile();
                wastePile.push(deck.pop());
                wastePile.topCard().showFace();
            }
        }else if (pressedComponent instanceof WastePile) {
            selectedTableau = null;
            wastePile = GamePanel.getWastePile();
            selectedCard = wastePile.topCard();
            if(selectedCard != null){
                for (Foundations foundations: GamePanel.getFoundations()) {
                    foundations.moveFromWastePile(wastePile, selectedCard);
                }
            }
        } else if (pressedComponent instanceof ShuffleButton) {
            selectedTableau = null;
            if (wastePile == null){
                wastePile = GamePanel.getWastePile();
            }
            wastePile.reshuffle(deck);

        }


        mouseEvent.getComponent().repaint();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {  //variable is only local so shadowing the name of the
                                                        //above function variable

        if (selectedCard != null){
            Component releasedComponent = mouseEvent.getComponent().getComponentAt(mouseEvent.getPoint());
        if (releasedComponent instanceof Tableau){
            if(wastePile != null) {
                Tableau destinationTableau = (Tableau) releasedComponent;
                if (!wastePile.isEmpty()) {
                    destinationTableau.moveFromWastePile(wastePile, selectedCard);
                }
                wastePile.repaint();
            }else if (selectedTableau != null){
                    Tableau sourceTableau = selectedTableau;
                    Tableau destinationTableau = (Tableau) releasedComponent;
                    sourceTableau.moveTo(destinationTableau, selectedCard);
                sourceTableau.repaint();
            } else if(selectedFoundation != null){
                Foundations sourceFoundation = selectedFoundation;
                Tableau destinationTableau = (Tableau) releasedComponent;
                sourceFoundation.moveTo(destinationTableau, selectedCard);
                sourceFoundation.repaint();
                destinationTableau.repaint();
            }
            }

            mouseEvent.getComponent().repaint();
            selectedCard = null;
            selectedTableau = null;
            selectedFoundation = null;
            wastePile = null;

            }
        }

        }






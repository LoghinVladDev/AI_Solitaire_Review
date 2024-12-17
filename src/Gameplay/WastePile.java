package Gameplay;

import Cards.Card;

import java.awt.*;
import java.util.List;

public class WastePile extends Pile{

    public WastePile(int x , int y){
        super(x,y);
        super.setSize(67, 97);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            if(!this.isEmpty()){
                graphics.drawImage(this.topCard().getCardFront(), 0,0, this.getWidth(), this.getHeight(),this);
            }
    }


}
